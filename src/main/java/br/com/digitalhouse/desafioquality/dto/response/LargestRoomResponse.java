package br.com.digitalhouse.desafioquality.dto.response;

public class LargestRoomResponse {
    private String propName;
    private RoomAreaResponse largestRoom;

    public LargestRoomResponse(String propName, RoomAreaResponse largestRoom) {
        this.propName = propName;
        this.largestRoom = largestRoom;
    }

    public LargestRoomResponse() {
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public RoomAreaResponse getLargestRoom() {
        return largestRoom;
    }

    public void setLargestRoom(RoomAreaResponse largestRoom) {
        this.largestRoom = largestRoom;
    }
}
