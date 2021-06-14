package br.com.digitalhouse.desafioquality.dto.response;

public class RoomAreaResponse {
    private String roomName;
    private double roomArea;

    public RoomAreaResponse(String roomName, double roomArea) {
        this.roomName = roomName;
        this.roomArea = roomArea;
    }

    public RoomAreaResponse() {
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(double roomArea) {
        this.roomArea = roomArea;
    }

}
