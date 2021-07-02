 package com.launchacademy.petadoption.controllers;

import com.launchacademy.petadoption.models.PetSurrenderApplication;
import com.launchacademy.petadoption.repositories.PetTypeRepository;
import com.launchacademy.petadoption.services.PetSurrenderApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

 @RestController
@RequestMapping("/api/v1/surrender")
public class PetSurrenderRestController {

     private PetSurrenderApplicationService petSurrenderApplicationService;
     private PetTypeRepository petTypeRepository;

     @Autowired
     public PetSurrenderRestController(PetSurrenderApplicationService petSurrenderApplicationService, PetTypeRepository petTypeRepository) {
         this.petSurrenderApplicationService = petSurrenderApplicationService;
         this.petTypeRepository = petTypeRepository;
     }

     @PostMapping
     public ResponseEntity savePetSurrender( @Valid @RequestBody  Map<String, String> petSurrenderApplication, BindingResult bindingResult) {
         if (bindingResult.hasErrors()) {
             return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
         } else {
             petSurrenderApplicationService.save(petSurrenderApplication);
             return new ResponseEntity<PetSurrenderApplication>(petSurrenderApplicationService.save(petSurrenderApplication), HttpStatus.CREATED);
         }
     }
 }




