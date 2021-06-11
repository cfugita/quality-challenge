package br.com.digitalhouse.desafioquality.service.validation;

import br.com.digitalhouse.desafioquality.dto.request.HouseRequest;
import br.com.digitalhouse.desafioquality.dto.request.RoomRequest;
import br.com.digitalhouse.desafioquality.service.exceptions.ValidationException;

import java.util.List;

public class ValidationRequest {

    public static Boolean validateHouseRequest(HouseRequest houseRequest) {
        validateName(houseRequest.getPropName(), "nome da propriedade", 30);
        validateName(houseRequest.getPropDistrict(), "nome do bairro", 45);
        validateListRooms(houseRequest.getRooms());
        for(RoomRequest room : houseRequest.getRooms()) {
            validateName(room.getRoomName(), "nome do cômodo", 30);
            validateMeasure(room.getLength(),"comprimento",33);
            validateMeasure(room.getWidth(),"largura",25);
        }
        return true;
    }

    public static void validateName (String name, String fieldName, Integer maxLength) {
        if(name.isEmpty()) { throw new ValidationException("O " + fieldName + " não pode estar vazio."); }
        if(name.length() > maxLength) { throw new ValidationException("O " + fieldName + " não pode exceder " + maxLength + " caracteres." ); }
        if(!Character.isUpperCase(name.charAt(0))) { throw new ValidationException("O " + fieldName + " deve começar com uma letra maiúscula" ); }
    }

    public static void validateMeasure (double measure, String measureName, Integer max) {
        if(measure == 0) { throw new ValidationException("A medida de " + measureName + " do cômodo não pode estar vazia."); }
        if(measure > max) { throw new ValidationException("A medida de " + measureName + " não pode exceder " + max + " metros." ); }
    }

    public static void validateListRooms (List<RoomRequest> rooms) {
        if(rooms.isEmpty()) { throw new ValidationException("Lista de cômodos não pode ser vazia."); }
    }
}
