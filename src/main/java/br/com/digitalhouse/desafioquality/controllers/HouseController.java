package br.com.digitalhouse.desafioquality.controllers;

import br.com.digitalhouse.desafioquality.dto.request.HouseRequest;
import br.com.digitalhouse.desafioquality.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {

    private HouseService houseService;

    public HouseController(HouseService houseService) { this.houseService = houseService; }

    @PostMapping("/area/total")
    ResponseEntity<Object> getTotalArea (@RequestBody HouseRequest houseRequest) {
        return new ResponseEntity<>(this.houseService.getTotalArea(houseRequest), HttpStatus.OK);
    }

    @PostMapping("/value")
    ResponseEntity<Object> getHouseValue (@RequestBody HouseRequest houseRequest) {
        return new ResponseEntity<>(this.houseService.getHouseValue(houseRequest), HttpStatus.OK);
    }

    @PostMapping("/area/rooms")
    ResponseEntity<Object> getAreaByRoom (@RequestBody HouseRequest houseRequest) {
        return new ResponseEntity<>(this.houseService.getAreaByRoom(houseRequest), HttpStatus.OK);
    }

    @PostMapping("/area/largest")
    ResponseEntity<Object> getLargestRoom (@RequestBody HouseRequest houseRequest) {
        return new ResponseEntity<>(this.houseService.getLargestRoom(houseRequest), HttpStatus.OK);
    }

}
