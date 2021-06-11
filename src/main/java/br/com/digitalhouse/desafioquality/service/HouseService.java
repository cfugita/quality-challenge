package br.com.digitalhouse.desafioquality.service;

import br.com.digitalhouse.desafioquality.dto.request.HouseRequest;
import br.com.digitalhouse.desafioquality.dto.response.HouseValueResponse;
import br.com.digitalhouse.desafioquality.dto.response.LargestRoomResponse;
import br.com.digitalhouse.desafioquality.dto.response.AllRoomsAreasResponse;
import br.com.digitalhouse.desafioquality.dto.response.HouseAreaResponse;

public interface HouseService {
    HouseAreaResponse getTotalArea (HouseRequest houseRequest);
    LargestRoomResponse getLargestRoom(HouseRequest houseRequest);
    AllRoomsAreasResponse getRoomArea (HouseRequest houseRequest);
    HouseValueResponse getHouseValue (HouseRequest houseRequest);
}
