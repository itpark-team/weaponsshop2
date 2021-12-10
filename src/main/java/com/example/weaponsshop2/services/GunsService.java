package com.example.weaponsshop2.services;

import com.example.weaponsshop2.models.Gun;
import com.example.weaponsshop2.repositories.GunsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GunsService {

    @Autowired
    private final GunsRepository gunsRepository;

    public GunsService(GunsRepository gunsRepository) {
        this.gunsRepository = gunsRepository;
    }

    public ArrayList<Gun> getAll() {
        return (ArrayList<Gun>) gunsRepository.findAll();
    }

    public Gun getById(int id) {
        return gunsRepository.findById(id).get();
    }

    public Gun insertOne(Gun gun) {
        return gunsRepository.saveAndFlush(gun);
    }

    public void deleteById(int id) {
        gunsRepository.deleteById(id);
    }

    public Gun updateById(int id, Gun gun){
        gun.id = id;
        return gunsRepository.save(gun);
    }

}
