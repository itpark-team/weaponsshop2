package com.example.weaponsshop2.controllers;

import com.example.weaponsshop2.dtos.GunDto;
import com.example.weaponsshop2.models.Gun;
import com.example.weaponsshop2.services.GunsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/guns", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GunsController {

    @Autowired
    private final GunsService gunsService;

    public GunsController(GunsService gunsService) {
        this.gunsService = gunsService;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("ERROR: " + exception.getMessage());
    }

    @GetMapping(value = "/getAll")
    public ArrayList<Gun> getAll() {
        return gunsService.getAll();
    }

    @GetMapping(value = "/getAllForMobile")
    public ArrayList<GunDto> getAllForMobile() {
        return gunsService.getAllForMobile();
    }

    @GetMapping(value = "/getById/{id}")
    public Gun getById(@PathVariable int id) {
        return gunsService.getById(id);
    }

    @PostMapping(value = "/insertOne")
    public Gun insertOne(@RequestBody Gun gun) {
        return gunsService.insertOne(gun);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        gunsService.deleteById(id);
    }

    @PutMapping(value = "/updateById/{id}")
    public Gun updateById(@PathVariable int id, @RequestBody Gun gun) {
        return gunsService.updateById(id, gun);
    }
}
