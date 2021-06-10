package br.com.digitalhouse.desafioquality.controllers;

import br.com.digitalhouse.desafioquality.dto.request.HouseRequest;
import br.com.digitalhouse.desafioquality.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/house")
public class HouseController {

    private HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/area/total")
    ResponseEntity<Object> getTotalArea (@RequestBody HouseRequest houseRequest) {
        return new ResponseEntity<>(this.houseService.getTotalArea(houseRequest), HttpStatus.OK);
    }

    @GetMapping("/area/rooms")
    ResponseEntity<Object> getRoomArea (@RequestBody HouseRequest houseRequest) {
        return new ResponseEntity<>(this.houseService.getRoomArea(houseRequest), HttpStatus.OK);
    }

    @GetMapping("/area/largest")
    ResponseEntity<Object> getBiggestRoom (@RequestBody HouseRequest houseRequest) {
        return new ResponseEntity<>(this.houseService.getLargestRoom(houseRequest), HttpStatus.OK);
    }


}
