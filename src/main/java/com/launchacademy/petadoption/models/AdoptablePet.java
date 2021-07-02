package com.launchacademy.petadoption.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "adoptable_pets")
@NoArgsConstructor
@Getter
@Setter
public class AdoptablePet {
    @Id
    @SequenceGenerator(name = "adoptable_pet_generator", sequenceName = "adoptable_pets_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adoptable_pet_generator")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @URL
    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @Column(name = "age")
    private Integer age;

    @Column(name = "vaccination_status")
    private Boolean vaccinationStatus;

    @NotNull
    @Column(name = "adoption_story", nullable = false)
    private String adoptionStory;

    @NotNull
    @Column(name = "adoption_status", nullable = false)
    private String adoptionStatus;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @JsonIgnoreProperties("adoptablePetList")
    private PetType petType;
}
