package br.com.digitalhouse.desafioquality.dto.request;

public class RoomRequest {
    private String roomName;
    private Double width;
    private Double length;

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

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getArea() {
        return this.getLength() * this.getWidth();
    }
}
