package com.launchacademy.petadoption.controllers;

import com.launchacademy.petadoption.models.AdoptablePet;
import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.repositories.AdoptablePetRepository;
import com.launchacademy.petadoption.repositories.PetTypeRepository;
import com.launchacademy.petadoption.services.AdoptablePetService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
public class PetsRestController {

    private final PetTypeRepository petTypeRepository;
    private final AdoptablePetService adoptablePetService;
    private AdoptablePetRepository adoptablePetRepository;

    public PetsRestController(PetTypeRepository petTypeRepository, AdoptablePetService adoptablePetService) {
        this.petTypeRepository = petTypeRepository;

        this.adoptablePetService = adoptablePetService;
    }

    @GetMapping
    public Page<PetType> getList(Pageable pageable) {
        return petTypeRepository.findAll(pageable);
    }

    @GetMapping("/{type}")
    public List<AdoptablePet> findAllByType(@PathVariable String type) {
        return adoptablePetService.findAllByType(type);
    }

    @GetMapping("/{type}/{id}")
    public AdoptablePet getAdoptablePet(@PathVariable String type, @PathVariable Integer id) {
        return adoptablePetService.findById(type,id);
    }
}
