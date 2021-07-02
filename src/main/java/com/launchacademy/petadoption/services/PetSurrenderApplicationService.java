package com.launchacademy.petadoption.services;

import com.launchacademy.petadoption.models.PetSurrenderApplication;
import com.launchacademy.petadoption.repositories.PetSurrenderApplicationRepository;
import com.launchacademy.petadoption.repositories.PetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PetSurrenderApplicationService {

    private PetSurrenderApplicationRepository petSurrenderApplicationRepository;
    private PetTypeRepository petTypeRepository;

    @Autowired
    public PetSurrenderApplicationService(PetSurrenderApplicationRepository petSurrenderApplicationRepository, PetTypeRepository petTypeRepository) {
        this.petSurrenderApplicationRepository = petSurrenderApplicationRepository;
        this.petTypeRepository = petTypeRepository;
    }

    public PetSurrenderApplication save(Map<String, String> petSurrenderApplication) {

        PetSurrenderApplication newPetSurrenderApplication = new PetSurrenderApplication();
        newPetSurrenderApplication.setName(petSurrenderApplication.get("name"));
        newPetSurrenderApplication.setPhoneNumber(petSurrenderApplication.get("phoneNumber"));
        newPetSurrenderApplication.setEmail(petSurrenderApplication.get("email"));
        newPetSurrenderApplication.setPetName(petSurrenderApplication.get("petName"));
        newPetSurrenderApplication.setPetAge(Integer.parseInt(petSurrenderApplication.get("petAge")));
        newPetSurrenderApplication.setPetType(petTypeRepository.findByTypeIgnoreCase(petSurrenderApplication.get("petType")));
        newPetSurrenderApplication.setPetImgUrl(petSurrenderApplication.get("petImageUrl"));
        newPetSurrenderApplication.setVaccinationStatus(Boolean.parseBoolean(petSurrenderApplication.get("vaccinationStatus")));
        newPetSurrenderApplication.setApplicationStatus("pending");

        return petSurrenderApplicationRepository.save(newPetSurrenderApplication);
    }
}

