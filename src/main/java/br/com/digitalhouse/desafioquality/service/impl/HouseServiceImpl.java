package br.com.digitalhouse.desafioquality.service.impl;

import br.com.digitalhouse.desafioquality.dto.request.HouseRequest;
import br.com.digitalhouse.desafioquality.dto.request.RoomRequest;
import br.com.digitalhouse.desafioquality.dto.response.*;
import br.com.digitalhouse.desafioquality.repository.DistrictRepository;
import br.com.digitalhouse.desafioquality.repository.entity.DistrictData;
import br.com.digitalhouse.desafioquality.service.HouseService;
import br.com.digitalhouse.desafioquality.service.validation.ValidationRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    public HouseServiceImpl() {
    }

    @Override
    public HouseAreaResponse getTotalArea (HouseRequest houseRequest) {
        Boolean isValid = ValidationRequest.validateHouseRequest(houseRequest);

        double totalArea = this.getRoomAreas(houseRequest.getRooms()).stream().mapToDouble(RoomAreaResponse::getRoomArea).sum();
        return new HouseAreaResponse (houseRequest.getPropName(), totalArea);
    }

    @Override
    public LargestRoomResponse getLargestRoom (HouseRequest houseRequest) {
        Boolean isValid = ValidationRequest.validateHouseRequest(houseRequest);

        RoomAreaResponse largestRoom = Collections.max(getRoomAreas(houseRequest.getRooms()),new AreaComp());
        return new LargestRoomResponse (houseRequest.getPropName(), largestRoom);
    }

    @Override
    public AllRoomsAreasResponse getAreaByRoom (HouseRequest houseRequest) {
        Boolean isValid = ValidationRequest.validateHouseRequest(houseRequest);

        return new AllRoomsAreasResponse (houseRequest.getPropName(), getRoomAreas(houseRequest.getRooms()));
    }

    @Override
    public HouseValueResponse getHouseValue(HouseRequest houseRequest) {
        Boolean isValid = ValidationRequest.validateHouseRequest(houseRequest);
        DistrictData district = DistrictRepository.findByName(houseRequest.getPropDistrict());
        double totalArea = this.getTotalArea(houseRequest).getTotalArea();
        return new HouseValueResponse (houseRequest.getPropName(), houseRequest.getPropDistrict(),district.getValue() * totalArea);
    }

    public List<RoomAreaResponse> getRoomAreas (List<RoomRequest> rooms) {

        List<RoomAreaResponse> roomAreaResponses = new ArrayList<>();
        for(RoomRequest room : rooms) { roomAreaResponses.add(new RoomAreaResponse (room.getRoomName(), room.getArea())); }

        return roomAreaResponses;
    }
}
