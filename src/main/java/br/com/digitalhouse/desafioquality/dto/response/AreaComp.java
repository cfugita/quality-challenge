package br.com.digitalhouse.desafioquality.dto.response;

import java.util.Comparator;

public class AreaComp implements Comparator<RoomAreaResponse> {
    @Override
    public int compare(RoomAreaResponse o1, RoomAreaResponse o2) {
        return Double.compare(o1.getRoomArea(), o2.getRoomArea());
    }
}
