package br.com.digitalhouse.desafioquality;

import br.com.digitalhouse.desafioquality.dto.request.HouseRequest;
import br.com.digitalhouse.desafioquality.dto.request.RoomRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class IntegrationTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    public static String houseRequestJson;

    @BeforeAll
    static void setUpHouseRequest () throws JsonProcessingException {
        List<RoomRequest> rooms = new ArrayList<>();
        RoomRequest room1 = new RoomRequest("Quarto 1", 3.0, 6.0);
        RoomRequest room2 = new RoomRequest("Cozinha", 1.0, 10.0);
        rooms.add(room1);
        rooms.add(room2);
        HouseRequest houseRequest = new HouseRequest("Carolina","Moema", rooms);

        ObjectMapper objectMapper = new ObjectMapper();
        houseRequestJson = objectMapper.writeValueAsString(houseRequest);
    }

    @BeforeEach
    void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void shouldReturnTotalAreaJSON () throws Exception {
        mvc.perform(
                post("/house/area/total")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(houseRequestJson))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnTotalValueJSON () throws Exception {
        mvc.perform(
                post("/house/value")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(houseRequestJson))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnRoomsAreasJSON () throws Exception {
        mvc.perform(
                post("/house/area/rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(houseRequestJson))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnLargestRoomJSON () throws Exception {

        mvc.perform(
                post("/house/area/largest")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(houseRequestJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.propName").value("Carolina"))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.largestRoom.roomName").value("Quarto 1"));
    }
}
