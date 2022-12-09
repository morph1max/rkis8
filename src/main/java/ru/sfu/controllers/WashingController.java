package ru.sfu.controllers;

import org.springframework.web.bind.annotation.*;
import ru.sfu.dao.WashingRepository;
import ru.sfu.models.Washing;

import java.util.ArrayList;
import java.util.List;


/**
 * Класс-контроллер для вывода всех объектов из БД.
 */
@RestController
public class WashingController {

    private final WashingRepository washingRepository;
    public WashingController(WashingRepository washingDAO) {
        this.washingRepository = washingDAO;
    }

    /**
     * Метод для вывода всех объектов из БД.
     */
    @GetMapping("/washing")
    public String getAllWashing() {

        ArrayList<Washing> washings = washingRepository.findAll();
        return washings.toString();
    }

    @GetMapping("/washing/{id}")
    public String getOneWashing(@PathVariable("id") int id) {

        Washing washing = washingRepository.findById(id);
        return washing.toString();
    }

    @PostMapping(value="/washing/add")
    public String addWashing(@RequestBody Washing washing) {

        washingRepository.insert(washing);
        return washing.toString();
    }

    @PutMapping("/washing/put/{id}")
    public String putWashing(
            @PathVariable("id") int id,
            @RequestBody Washing washing
    ) {

        washingRepository.edit(id, washing);
        return washing.toString();
    }

    @DeleteMapping("/washing/delete/{id}")
    public String deleteWashing(@PathVariable("id") int id) {

        Washing washing = washingRepository.delete(id);
        return washing.toString();
    }
}
