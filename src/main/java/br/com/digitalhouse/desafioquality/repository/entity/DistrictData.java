package br.com.digitalhouse.desafioquality.repository.entity;

public class DistrictData {
    private String name;
    private double value;

    public DistrictData(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public DistrictData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
