package com.launchacademy.petadoption.services;

import com.launchacademy.petadoption.models.AdoptablePet;
import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.repositories.AdoptablePetRepository;
import com.launchacademy.petadoption.repositories.PetTypeRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service

public class AdoptablePetService {
    private AdoptablePetRepository adoptablePetRepository;
    private PetTypeRepository petTypeRepository;

    @Autowired
    public AdoptablePetService(AdoptablePetRepository adoptablePetRepository, PetTypeRepository petTypeRepository) {
        this.adoptablePetRepository = adoptablePetRepository;
        this.petTypeRepository = petTypeRepository;
    }

  public List<AdoptablePet> findAllByType(String type) {
      PetType petType = petTypeRepository.findByTypeIgnoreCase(type);
      return adoptablePetRepository.findPetsByType(petType.getId());
  }
  public AdoptablePet findById(String type, Integer id) {
        PetType typePet = petTypeRepository.findByTypeIgnoreCase(type);
        return (AdoptablePet) adoptablePetRepository.findPetsById(typePet.getId(), id).orElseThrow(() -> new AdoptablePetNotFoundException());
    }

    @NoArgsConstructor
    public class AdoptablePetNotFoundException extends RuntimeException{};

    @ControllerAdvice
    private class AdoptablePetNotFoundAdvice{
        @ResponseBody
        @ExceptionHandler(AdoptablePetNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        String adoptablePetNotFoundHandler(AdoptablePetNotFoundException ex) {
            return ex.getMessage();
        }
    }
}
