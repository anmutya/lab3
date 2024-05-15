package an_mutya.lab3;

import entities.*;
import org.springframework.stereotype.Service;
import reactor.Reactor;
import reader.JsonReader;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReactorService {
    private ReactorRepository reactorRepository;

    public ReactorService(ReactorRepository reactorRepository) {
        this.reactorRepository = reactorRepository;
    }

    private double findBurnup(Reactors reactors) {
        JsonReader jsonReader = new JsonReader();
        double burnup = 0;
        ArrayList<Reactor> reactorStorage = jsonReader.readFile();
        for (Reactor reactor : reactorStorage) {
            if (Objects.equals(reactor.getType(), reactors.getType())) {
                burnup = reactor.getBurnup();
            } else if (Objects.equals(reactors.getType(), "LWGR") && Objects.equals(reactor.getType(), "RBMK")) {
                burnup = reactor.getBurnup();
            } else if (Objects.equals(reactors.getType(), "GCR") && Objects.equals(reactor.getType(), "MAGNOX")) {
                burnup = reactor.getBurnup();
            } else if (Objects.equals(reactors.getType(), "FBR") && Objects.equals(reactor.getType(), "BN")) {
                burnup = reactor.getBurnup();
            }
        }
        return burnup;
    }

    private double findFirstLoad(Reactors reactors) {
        JsonReader jsonReader = new JsonReader();
        double firstLoad = 0;
        ArrayList<Reactor> reactorStorage = jsonReader.readFile();
        for (Reactor reactor : reactorStorage) {
            if (Objects.equals(reactor.getType(), reactors.getType())) {
                firstLoad = reactor.getFirstLoad();
            } else if (Objects.equals(reactors.getType(), "LWGR") && Objects.equals(reactor.getType(), "RBMK")) {
                firstLoad = reactor.getFirstLoad();
            } else if (Objects.equals(reactors.getType(), "GCR") && Objects.equals(reactor.getType(), "MAGNOX")) {
                firstLoad = reactor.getFirstLoad();
            } else if (Objects.equals(reactors.getType(), "FBR") && Objects.equals(reactor.getType(), "BN")) {
                firstLoad = reactor.getFirstLoad();
            }
        }
        return firstLoad;
    }

    private List<Integer> calculateMissingYears(List<Kium> kiums) {
        List<Integer> yearsKium = kiums.stream().map(Kium::getYear).toList();
        int[] years = {2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024};
        Set<Integer> setOfYearsKium = new HashSet<>(yearsKium);
        List<Integer> missingYears = Arrays.stream(years)
                .boxed()
                .filter(year -> !setOfYearsKium.contains(year))
                .toList();
        return missingYears;
    }

    private Integer dataFormatToOnlyYear(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int year = date != null ? Integer.parseInt(dateFormat.
                format(date).substring(0, 4)) : Integer.MAX_VALUE;
        return year;
    }

    private Map<Integer, Double> calculateEnergyForKnownYears(Reactors reactor) {
        Map<Integer, Double> energyByYear = new HashMap<>();
        int shutdownYear = dataFormatToOnlyYear(reactor.getShutdownDate());
        int firstGridYear = dataFormatToOnlyYear(reactor.getFirstGridConnection());
        for (Kium kium : reactor.getKiums()) {
            double energy = 0;
            double loadFactor = 0;
            if (shutdownYear > kium.getYear() && firstGridYear < kium.getYear()) {
                loadFactor = kium.getLoadFactor() == null ? 0.85 : kium.getLoadFactor() / 100;
                energy = loadFactor * reactor.getThermalCapacity() / findBurnup(reactor);
            } else if (firstGridYear == kium.getYear()) {
                loadFactor = kium.getLoadFactor() == null ? findFirstLoad(reactor) : kium.getLoadFactor() / 100;
                energy = 3 * loadFactor * reactor.getThermalCapacity() / findBurnup(reactor);
            }
            energyByYear.merge(kium.getYear(), energy, Double::sum);
        }
        return energyByYear;
    }

    private Map<Integer, Double> calculateEnergyForMissinigYears(Reactors reactor) {
        List<Integer> missingYears = calculateMissingYears(reactor.getKiums());
        Map<Integer, Double> energyByYear = new HashMap<>();
        int shutdownYear = dataFormatToOnlyYear(reactor.getShutdownDate());
        int firstGridYear = dataFormatToOnlyYear(reactor.getFirstGridConnection());
        for (Integer year : missingYears) {
            double energy;
            if (shutdownYear > year && firstGridYear < year) {
                double loadFactor = 0.85;
                energy = loadFactor * reactor.getThermalCapacity() / findBurnup(reactor);
            } else if (firstGridYear == year) {
                double loadFactor = findFirstLoad(reactor);
                energy = loadFactor * reactor.getThermalCapacity() / findBurnup(reactor);
            } else {
                energy = 0;
            }
            energyByYear.merge(year, energy, Double::sum);
        }
        return energyByYear;
    }

    private Map<Integer, Double> calculateEnergy(List<Reactors> reactors) {
        Map<Integer, Double> totalEnergyByYear = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Reactors reactor : reactors) {
            Map<Integer, Double> energyForKnownYears = null;
            Map<Integer, Double> energyForMissingYears = null;
            if (reactor.getEnergyByYear().isEmpty()) {
                energyForKnownYears = calculateEnergyForKnownYears(reactor);
                energyForMissingYears = calculateEnergyForMissinigYears(reactor);
                energyForKnownYears.forEach((key, value) -> totalEnergyByYear.merge(key, value, Double::sum));
                energyForMissingYears.forEach((key, value) -> totalEnergyByYear.merge(key, value, Double::sum));
            } else {
                energyForKnownYears = reactor.getEnergyByYear();
                energyForKnownYears.forEach((key, value) -> totalEnergyByYear.merge(key, value, Double::sum));
            }
        }
        return totalEnergyByYear;
    }

    public void calculateReactorEnergyByCountryAndYear() {
        ArrayList<Countries> results = reactorRepository.findReactorsEnergyByCountries();
        Map<String, Map<Integer, Double>> energyByCountryAndYear = new HashMap<>();
        for (Countries country : results) {
            List<Reactors> reactors = country.getReactors();
            Map<Integer, Double> energyForCountry = calculateEnergy(reactors);
            energyByCountryAndYear.put(country.getName(), energyForCountry);
        }
        Map<String, Map<Integer, Double>> sortedMapByYear = sortedMapByYear(energyByCountryAndYear);
        sortedMapByYear.forEach((country, yearToEnergy) ->
                yearToEnergy.forEach((year, energy) ->
                        System.out.println("Country: " + country + ", Year: " + year + ", Energy: " + energy)));
    }

    private Map<String, Map<Integer, Double>> sortedMapByYear(Map<String, Map<Integer, Double>> energyByCountryAndYear) {
        List<Map.Entry<String, Map<Integer, Double>>> countryEntries = new ArrayList<>(energyByCountryAndYear.entrySet());
        countryEntries.forEach(countryEntry -> {
            Map<Integer, Double> sortedYearToEnergy = countryEntry.getValue()
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            energyByCountryAndYear.put(countryEntry.getKey(), sortedYearToEnergy);
        });
        return energyByCountryAndYear;
    }

    public void calculateReactorEnergyByRegionAndYear() {
        ArrayList<Regions> results = reactorRepository.findReactorsEnergyByRegions();
        Map<String, Map<Integer, Double>> energyByCountryAndYear = new HashMap<>();
        for (Regions region : results) {
            List<Countries> countries = region.getCountries();
            for (Countries country : countries) {
                List<Reactors> reactors = country.getReactors();
                Map<Integer, Double> energyForRegion = calculateEnergy(reactors);
                energyByCountryAndYear.put(region.getName(), energyForRegion);
            }
        }
        Map<String, Map<Integer, Double>> sortedMapByYear = sortedMapByYear(energyByCountryAndYear);
        sortedMapByYear.forEach((region, yearToEnergy) ->
                yearToEnergy.forEach((year, energy) ->
                        System.out.println("Region: " + region + ", Year: " + year + ", Energy: " + energy)));
    }

    public void calculateReactorEnergyByOwnerAndOperator() {
        ArrayList<ArrayList<Reactors>> results = reactorRepository.findReactorsByOwnerAndOperator();
        Map<String, Map<String, Map<Integer, Double>>> energyByCountryAndYear = new HashMap<>();
        for (ArrayList<Reactors> reactors : results) {
            String ownerName = reactors.get(0).getOwner().getName();
            String operatorName = reactors.get(0).getOperator().getName();
            Map<Integer, Double> energyForRegion = calculateEnergy(reactors);
            energyByCountryAndYear
                    .computeIfAbsent(ownerName, k -> new HashMap<>())
                    .computeIfAbsent(operatorName, k -> new HashMap<>())
                    .putAll(energyForRegion);
        }
        energyByCountryAndYear.forEach((owner, operatorToEnergyMap) ->
                operatorToEnergyMap.forEach((operator, yearToEnergy) ->
                        yearToEnergy.forEach((year, energy) ->
                                System.out.println("Owner: " + owner + ", Operator: " + operator + ", Year: " + year + ", Energy: " + energy))));
    }

}

