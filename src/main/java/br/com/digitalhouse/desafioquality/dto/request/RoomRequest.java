package br.com.digitalhouse.desafioquality.dto.request;

public class RoomRequest {
    private String roomName;
    private double width;
    private double length;

    public RoomRequest(String roomName, double width, double length) {
        this.roomName = roomName;
        this.width = width;
        this.length = length;
    }

    public RoomRequest() {
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.getLength() * this.getWidth();
    }
}
