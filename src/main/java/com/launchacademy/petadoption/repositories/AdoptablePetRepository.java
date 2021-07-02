package com.launchacademy.petadoption.repositories;

import com.launchacademy.petadoption.models.AdoptablePet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdoptablePetRepository extends PagingAndSortingRepository <AdoptablePet, Integer> {

    @Query("SELECT a from AdoptablePet a WHERE type_id = :id")
    List<AdoptablePet> findPetsByType(@Param("id") Integer id);

    @Query("SELECT a from AdoptablePet a WHERE type_id = :id and id = :id1")
    Optional<Object> findPetsById(@Param("id") Integer id, @Param("id1") Integer id1);
}
