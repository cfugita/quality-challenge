package br.com.digitalhouse.desafioquality.service.impl;

import br.com.digitalhouse.desafioquality.dto.request.HouseRequest;
import br.com.digitalhouse.desafioquality.dto.request.RoomRequest;
import br.com.digitalhouse.desafioquality.dto.response.*;
import br.com.digitalhouse.desafioquality.service.HouseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Override
    public HouseAreaResponse getTotalArea(HouseRequest houseRequest) {

        double totalArea = houseRequest.getRooms().stream().mapToDouble(RoomRequest::getArea).sum();

        return new HouseAreaResponse(houseRequest.getPropName(),totalArea);
    }

    @Override
    public LargestRoomResponse getLargestRoom(HouseRequest houseRequest) {

        RoomAreaResponse largestRoom = Collections.max(getRoomAreas(houseRequest.getRooms()),new AreaComp());

        return new LargestRoomResponse(houseRequest.getPropName(),largestRoom);
    }

    @Override
    public AllRoomsAreasResponse getRoomArea(HouseRequest houseRequest) {

        return new AllRoomsAreasResponse(houseRequest.getPropName(), getRoomAreas(houseRequest.getRooms()));
    }

    public List<RoomAreaResponse> getRoomAreas (List<RoomRequest> rooms) {

        List<RoomAreaResponse> roomAreaResponses = new ArrayList<>();

        for(RoomRequest room : rooms) {
            roomAreaResponses.add(new RoomAreaResponse(room.getRoomName(), room.getArea()));
        }

        return roomAreaResponses;
    }
}
