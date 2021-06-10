package br.com.digitalhouse.desafioquality.dto.request;

import java.util.List;

public class HouseRequest {
    private String propName;
    private String propDistrict;
    private List<RoomRequest> rooms;

    public HouseRequest(String propName, String propDistrict, List<RoomRequest> rooms) {
        this.propName = propName;
        this.propDistrict = propDistrict;
        this.rooms = rooms;
    }

    public HouseRequest() {;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getPropDistrict() {
        return propDistrict;
    }

    public void setPropDistrict(String propDistrict) {
        this.propDistrict = propDistrict;
    }

    public List<RoomRequest> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomRequest> rooms) {
        this.rooms = rooms;
    }
}
