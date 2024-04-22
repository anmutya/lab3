    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package an_mutya.lab3;

/**
 *
 * @author annamutovkina
 */
public class Reactor {
    private String class_type;
    private double burnup;
    private double kpd;
    private double enrichment;
    private double thermal_capacity;
    private double electrical_capacity;
    private int life_time;
    private double first_load;
      public Reactor() {
    }
    public Reactor(String class_type, double burnup, double kpd, double enrichment, double thermal_capacity, double electrical_capacity, int life_time, double first_load) {
        this.class_type = class_type;
        this.burnup = burnup;
        this.kpd = kpd;
        this.enrichment = enrichment;
        this.thermal_capacity = thermal_capacity;
        this.electrical_capacity = electrical_capacity;
        this.life_time = life_time;
        this.first_load = first_load;
    }
    public String getClassType() {
        return class_type;
    }
    public double getBurnup() {
        return burnup;
    }
    public double getKpd() {
        return kpd;
    }
    public double getEnrichment() {
        return enrichment;
    }
    public double getThermalCapacity() {
        return thermal_capacity;
    }
    public double getElectricalCapacity() {
        return electrical_capacity;
    }
    public int getLifeTime() {
        return life_time;
    }
    public double getFirstLoad() {
        return first_load;
    }
    public void setType(String class_type) {
        this.class_type = class_type;
    }
    public void setBurnup(double burnup) {
        this.burnup = burnup;
    }
    public void setKpd(double kpd) {
        this.kpd = kpd;
    }
    public void setEnrichment(double enrichment) {
        this.enrichment = enrichment;
    }
    public void setThermalCpacity(double thermal_capacity) {
        this.thermal_capacity = thermal_capacity;
    }
    public void setElectricalCapacity(double electrical_capacity) {
        this.electrical_capacity = electrical_capacity;
    }
    public void setLifeTime(int life_time) {
        this.life_time = life_time;
    }
    public void setFirstLoad(double first_load) {
        this.first_load = first_load;
    }
        @Override
    public String toString() {
        return "Reactor{" + "class=" + class_type + ", burnup=" + burnup + ", kpd=" + kpd + ", enrichment=" + 
                enrichment + ", thermal_capacity=" + thermal_capacity + ", electrical_capacity=" + electrical_capacity +
                ", life_time=" + life_time + ", first_load=" + first_load + '}';
    }

}
