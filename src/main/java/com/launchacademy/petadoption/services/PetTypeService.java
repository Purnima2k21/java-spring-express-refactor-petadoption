package com.launchacademy.petadoption.services;

import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PetTypeService {

    private PetTypeRepository petTypeRepository;

    @Autowired
    public PetTypeService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    public List<PetType> getList() {
        return (List<PetType>) petTypeRepository.findAll();
    }

    public void addToList(PetType petType) {

        petTypeRepository.save(petType);
    }
}
