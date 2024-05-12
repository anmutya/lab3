package an_mutya.lab3;

import entyties.Countries;
import entyties.Kium;
import entyties.Operators;
import entyties.Owners;
import entyties.Reactors;
import entyties.Regions;
import entyties.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author annamutovkina
 */
public class CreateEntitiesForDB {

    private String path = "/Users/annamutovkina/Downloads/reactors_details.xlsx";

    public ArrayList<Reactors> createReactors() throws IOException {
        ArrayList<Reactors> reactors = new ArrayList<>();
        String nameSheet = "reactor";
        DataFormatter formatter = new DataFormatter();
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet(nameSheet);
            for (int i = 1; i <= myExcelSheet.getLastRowNum(); i++) {
                Reactors reactor = new Reactors();
                Row row = myExcelSheet.getRow(i);
                String cellValue = formatter.formatCellValue(row.getCell(0));
                reactor.setId(Integer.valueOf(cellValue));
                reactor.setName(row.getCell(1).getStringCellValue());
                reactor.setType(row.getCell(2).getStringCellValue());
                reactor.setModel(row.getCell(3).getStringCellValue());
                int statusId = (int) (row.getCell(4).getNumericCellValue());
                if (statusId != 0) {
                    Status status = new Status();
                    status.setId(statusId);
                    reactor.setStatus(status);
                }
                int ownerId = (int) (row.getCell(5).getNumericCellValue());
                if (ownerId != 0) {
                    Owners owner = new Owners();
                    owner.setId(ownerId);
                    reactor.setOwner(owner);
                }
                int operatorId = (int) (row.getCell(6).getNumericCellValue());
                if (operatorId != 0) {
                    Operators operator = new Operators();
                    operator.setId(operatorId);
                    reactor.setOperator(operator);
                }
                cellValue = formatter.formatCellValue(row.getCell(7));
                reactor.setThermalCapacity(Integer.valueOf(cellValue));
                reactor.setFirstGridConnection(row.getCell(8).getStringCellValue());
                reactor.setShutdownDate(row.getCell(9).getStringCellValue());

                int countryId = (int) (row.getCell(10).getNumericCellValue());
                if (countryId != 0) {
                    Countries country = new Countries();
                    country.setId(countryId);
                    reactor.setCountry(country);
                }
                reactors.add(reactor);
            }
            myExcelFWorkbook.close();
        }
        return reactors;

    }

    public ArrayList<Operators> createOperators() {
        ArrayList<Operators> operatorses = new ArrayList();
        String nameSheet = "operators";
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            DataFormatter formatter = new DataFormatter();
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet(nameSheet);
            for (int i = 1; i <= myExcelSheet.getLastRowNum(); i++) {
                Operators op = new Operators();
                Row row = myExcelSheet.getRow(i);
                String cellValue = formatter.formatCellValue(row.getCell(0));
                op.setId(Integer.valueOf(cellValue));
                op.setName(row.getCell(1).getStringCellValue());
                operatorses.add(op);
            }
            myExcelFWorkbook.close();
        } catch (IOException ex) {
            Logger.getLogger(CreateEntitiesForDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operatorses;
    }

    public ArrayList<Owners> createOwners() {
        ArrayList<Owners> owners = new ArrayList();
        String nameSheet = "owners";
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            DataFormatter formatter = new DataFormatter();
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet(nameSheet);
            for (int i = 1; i <= myExcelSheet.getLastRowNum(); i++) {
                Owners owner = new Owners();
                Row row = myExcelSheet.getRow(i);
                String cellValue = formatter.formatCellValue(row.getCell(0));
                owner.setId(Integer.valueOf(cellValue));
                owner.setName(row.getCell(1).getStringCellValue());
                owners.add(owner);
            }
            myExcelFWorkbook.close();
        } catch (IOException ex) {
            Logger.getLogger(CreateEntitiesForDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return owners;
    }

    public ArrayList<Regions> createRegions() {
        ArrayList<Regions> regions = new ArrayList();
        String nameSheet = "regions";
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            DataFormatter formatter = new DataFormatter();
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet(nameSheet);
            for (int i = 1; i <= myExcelSheet.getLastRowNum(); i++) {
                Regions region = new Regions();
                Row row = myExcelSheet.getRow(i);
                String cellValue = formatter.formatCellValue(row.getCell(0));
                region.setId(Integer.valueOf(cellValue));
                region.setName(row.getCell(1).getStringCellValue());
                regions.add(region);
            }
            myExcelFWorkbook.close();
        } catch (IOException ex) {
            Logger.getLogger(CreateEntitiesForDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return regions;
    }

    public ArrayList<Countries> createCountries() {
        ArrayList<Countries> countries = new ArrayList();
        String nameSheet = "countries";
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            DataFormatter formatter = new DataFormatter();
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet(nameSheet);
            for (int i = 1; i <= myExcelSheet.getLastRowNum(); i++) {
                Countries country = new Countries();
                Row row = myExcelSheet.getRow(i);
                String cellValue = formatter.formatCellValue(row.getCell(0));
                country.setId(Integer.valueOf(cellValue));
                int regionId = (int) (row.getCell(1).getNumericCellValue());
                if (regionId != 0) {
                    Regions region = new Regions();
                    region.setId(regionId);
                    country.setRegion(region);
                }
                country.setName(row.getCell(2).getStringCellValue());
                countries.add(country);
            }
            myExcelFWorkbook.close();
        } catch (IOException ex) {
            Logger.getLogger(CreateEntitiesForDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countries;
    }

    public ArrayList<Status> createStatus() {
        ArrayList<Status> statuses = new ArrayList();
        String nameSheet = "status";
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            DataFormatter formatter = new DataFormatter();
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet(nameSheet);
            for (int i = 1; i <= myExcelSheet.getLastRowNum(); i++) {
                Status status = new Status();
                Row row = myExcelSheet.getRow(i);
                String cellValue = formatter.formatCellValue(row.getCell(0));
                status.setId(Integer.valueOf(cellValue));
                status.setName(row.getCell(1).getStringCellValue());
                statuses.add(status);
            }
            myExcelFWorkbook.close();
        } catch (IOException ex) {
            Logger.getLogger(CreateEntitiesForDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return statuses;
    }

    public ArrayList<Kium> createKium() {
        ArrayList<Kium> kiums = new ArrayList();
        String nameSheet = "kium";
        try (XSSFWorkbook myExcelFWorkbook = new XSSFWorkbook(path)) {
            DataFormatter formatter = new DataFormatter();
            XSSFSheet myExcelSheet = myExcelFWorkbook.getSheet(nameSheet);
            for (int i = 1; i <= myExcelSheet.getLastRowNum(); i++) {
                Kium kium = new Kium();
                Row row = myExcelSheet.getRow(i);
                int reactorId = (int) (row.getCell(0).getNumericCellValue());
                if (reactorId != 0) {
                    Reactors reactor = new Reactors();
                    reactor.setId(reactorId);
                    kium.setReactor(reactor);
                }
                String cellValue = formatter.formatCellValue(row.getCell(1));
                kium.setYear(Integer.valueOf(cellValue));
                if ((int)row.getCell(2).getNumericCellValue() != 0) {
                    kium.setLoadFactor(row.getCell(2).getNumericCellValue());
                }
                kiums.add(kium);
            }
            myExcelFWorkbook.close();
        } catch (IOException ex) {
            Logger.getLogger(CreateEntitiesForDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kiums;
    }
}
