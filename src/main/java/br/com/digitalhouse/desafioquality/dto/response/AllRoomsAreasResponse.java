package br.com.digitalhouse.desafioquality.dto.response;

import java.util.List;

public class AllRoomsAreasResponse {
    private String propName;
    private List<RoomAreaResponse> roomsAreas;

    public AllRoomsAreasResponse(String propName, List<RoomAreaResponse> roomsAreas) {
        this.propName = propName;
        this.roomsAreas = roomsAreas;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public List<RoomAreaResponse> getRoomsAreas() {
        return roomsAreas;
    }

    public void setRoomsAreas(List<RoomAreaResponse> roomsAreas) {
        this.roomsAreas = roomsAreas;
    }
}
