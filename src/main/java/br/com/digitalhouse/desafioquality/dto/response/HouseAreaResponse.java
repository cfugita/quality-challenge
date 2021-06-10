package br.com.digitalhouse.desafioquality.dto.response;

public class HouseAreaResponse {
    private String propName;
    private double totalArea;

    public HouseAreaResponse(String propName, double totalArea) {
        this.propName = propName;
        this.totalArea = totalArea;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }
}
