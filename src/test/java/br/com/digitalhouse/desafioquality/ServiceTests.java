package br.com.digitalhouse.desafioquality;

import br.com.digitalhouse.desafioquality.dto.request.HouseRequest;
import br.com.digitalhouse.desafioquality.dto.request.RoomRequest;
import br.com.digitalhouse.desafioquality.dto.response.RoomAreaResponse;
import br.com.digitalhouse.desafioquality.service.impl.HouseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceTests {

    public static HouseRequest houseRequest;

    @BeforeAll
    static void setUpHouseRequest () {
        List<RoomRequest> rooms = new ArrayList<>();
        RoomRequest room1 = new RoomRequest("Quarto 1", 3.0, 6.0);
        RoomRequest room2 = new RoomRequest("Cozinha", 1.0, 10.0);
        rooms.add(room1);
        rooms.add(room2);
        houseRequest = new HouseRequest("Carolina","Moema", rooms);
    }

    @Test
    void shouldCalculateArea () {
        HouseServiceImpl houseService = new HouseServiceImpl();
        double totalAreaExp = 28.0;

        double totalArea = houseService.getTotalArea(houseRequest).getTotalArea();

        Assertions.assertEquals(totalAreaExp, totalArea);
    }

    @Test
    void shouldGetLargestRoom () {
        HouseServiceImpl houseService = new HouseServiceImpl();
        double largestRoomAreaExp = 18.0;

        double largestRoomArea = houseService.getLargestRoom(houseRequest).getLargestRoom().getRoomArea();

        Assertions.assertEquals(largestRoomAreaExp, largestRoomArea);
    }

    @Test
    void shouldGetLargestRoomName () {
        HouseServiceImpl houseService = new HouseServiceImpl();
        String largestRoomNameExp = "Quarto 1";

        String largestRoomName = houseService.getLargestRoom(houseRequest).getLargestRoom().getRoomName();

        Assertions.assertEquals(largestRoomNameExp, largestRoomName);
    }

    @Test
    void shouldGetRoomsAreas () {
        HouseServiceImpl houseService = new HouseServiceImpl();
        double [] roomsAreasExp = {18.0, 10.0};

        List<RoomAreaResponse> roomsAreas = houseService.getAreaByRoom(houseRequest).getRoomsAreas();

        Assertions.assertEquals(roomsAreasExp[0], roomsAreas.get(0).getRoomArea());
        Assertions.assertEquals(roomsAreasExp[1], roomsAreas.get(1).getRoomArea());
    }

    @Test
    void shouldGetTotalHouseValue () {
        HouseServiceImpl houseService = new HouseServiceImpl();
        double totalValueExp = 326312;

        double totalValue = houseService.getHouseValue(houseRequest).getTotalValue();

        Assertions.assertEquals(totalValueExp,totalValue);
    }

}
