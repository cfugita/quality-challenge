package br.com.digitalhouse.desafioquality.dto.response;

public class HouseValueResponse {
    private String propName;
    private String district;
    private double totalValue;

    public HouseValueResponse(String propName, String district, double totalValue) {
        this.propName = propName;
        this.district = district;
        this.totalValue = totalValue;
    }

    public HouseValueResponse() {
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
