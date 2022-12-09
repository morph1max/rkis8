package ru.sfu.dao;


import org.springframework.stereotype.Repository;
import ru.sfu.models.Washing;

import java.util.ArrayList;

/**
 * Класс для обработки запросов к БД.
 */
@Repository
public class WashingRepository {

    ArrayList<Washing> washings = new ArrayList<Washing>();

    public Washing insert(Washing washing) {
        washings.add(washing);
        return washing;
    }

    public Washing edit(int id, Washing washing) {

        Washing editWashing = null;
        for (Washing w: washings) {
            if (w.getId() == id) {
                editWashing = w;
                break;
            }
        }

        editWashing.setId(washing.getId());
        editWashing.setModel(washing.getModel());
        editWashing.setClothingCapacity(washing.getClothingCapacity());
        editWashing.setWeight(washing.getWeight());
        editWashing.setManufacturingCompany(washing.getManufacturingCompany());
        editWashing.setProducingCountry(washing.getProducingCountry());
        return washing;
    }

    public Washing delete(int id) {
        Washing washing = null;
        for (Washing w: washings) {
            if (w.getId() == id) {
                washing = w;
                break;
            }
        }

        washings.remove(washing);
        return washing;
    }

    public Washing findById(int id) {

        Washing washing = null;
        for (Washing w: washings) {
            if (w.getId() == id) {
                washing = w;
                break;
            }
        }
        return washing;
    }

    public ArrayList<Washing> findAll() {
        return washings;
    }
}
