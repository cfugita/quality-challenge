package br.com.digitalhouse.desafioquality;

import br.com.digitalhouse.desafioquality.dto.request.HouseRequest;
import br.com.digitalhouse.desafioquality.dto.request.RoomRequest;
import br.com.digitalhouse.desafioquality.service.exceptions.ValidationException;
import br.com.digitalhouse.desafioquality.service.validation.ValidationRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ValidationTests {

    private static HouseRequest houseRequest;

    @BeforeEach
    void setUpHouseRequest() {
        List<RoomRequest> rooms = new ArrayList<>();
        RoomRequest room1 = new RoomRequest("Quarto 1", 3.0, 6.0);
        RoomRequest room2 = new RoomRequest("Cozinha", 1.0, 10.0);
        rooms.add(room1);
        rooms.add(room2);
        houseRequest = new HouseRequest("Carolina","Moema", rooms);
    }

    @Test
    void shouldValidateHouseRequest() {

        Boolean isValid = ValidationRequest.validateHouseRequest(houseRequest);

        Assertions.assertTrue(isValid);
    }

    @Test
    void shouldThrowExceptionNullPropName() {

        houseRequest.setPropName("");

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("O nome da propriedade não pode estar vazio.",ex.getMessage());
    }

    @Test
    void shouldThrowExceptionExceedPropName() {

        houseRequest.setPropName("GreatNameGreatNameGreatNameGreatNameGreatNameGreatNameGreatNameGreatName");

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("O nome da propriedade não pode exceder 30 caracteres.",ex.getMessage());
    }

    @Test
    void shouldThrowExceptionLowerCasePropName() {

        houseRequest.setPropName("carolina");

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("O nome da propriedade deve começar com uma letra maiúscula.",ex.getMessage());
    }

    @Test
    void shouldThrowExceptionNullDistrictName() {

        houseRequest.setPropDistrict("");

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("O nome do bairro não pode estar vazio.",ex.getMessage());
    }

    @Test
    void shouldThrowExceptionExceedDistrictName() {

        houseRequest.setPropDistrict("GreatNameGreatNameGreatNameGreatNameGreatNameGreatNameGreatNameGreatName");

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("O nome do bairro não pode exceder 45 caracteres.",ex.getMessage());
    }

    @Test
    void shouldThrowExceptionEmptyRoomList() {

        houseRequest.setRooms(new ArrayList<>());

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("Lista de cômodos não pode ser vazia.",ex.getMessage());
    }

    @Test
    void shouldThrowExceptionNullRoomName() {

        houseRequest.getRooms().get(0).setRoomName("");

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("O nome do cômodo não pode estar vazio.",ex.getMessage());
    }

    @Test
    void shouldThrowExceptionExceedRoomName() {

        houseRequest.getRooms().get(0).setRoomName("GreatNameGreatNameGreatNameGreatNameGreatNameGreatNameGreatNameGreatName");

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("O nome do cômodo não pode exceder 30 caracteres.",ex.getMessage());
    }

    @Test
    void shouldThrowExceptionLowerCaseRoomName() {

        houseRequest.getRooms().get(0).setRoomName("quarto");

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("O nome do cômodo deve começar com uma letra maiúscula.",ex.getMessage());
    }


//	@Test
//	void shouldThrowExceptionNullRoomWidth() {
//
//		houseRequest.getRooms().get(0).setWidth(null);
//
//		Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
//		Assertions.assertEquals("O nome do cômodo não pode estar vazio.",ex.getMessage());
//	}

    @Test
    void shouldThrowExceptionExceedRoomWidth() {

        houseRequest.getRooms().get(0).setWidth(26.0);

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("A medida de largura não pode exceder 25 metros.",ex.getMessage());
    }

    @Test
    void shouldThrowExceptionExceedRoomLength() {

        houseRequest.getRooms().get(0).setLength(50.0);

        Exception ex = Assertions.assertThrows(ValidationException.class, () -> ValidationRequest.validateHouseRequest(houseRequest));
        Assertions.assertEquals("A medida de comprimento não pode exceder 33 metros.",ex.getMessage());
    }

}
