package com.launchacademy.petadoption.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "pet_types")
@NoArgsConstructor
@Getter
@Setter
public class PetType {
    @Id
    @SequenceGenerator(name = "pet_type_generator", sequenceName = "pet_types_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_type_generator")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @NotNull
    @Column(name = "type", nullable = false)
    private String type;

    @URL
    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "petType", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("petType")
    private List<AdoptablePet> adoptablePetList;
    @OneToMany(mappedBy = "petType", cascade = CascadeType.ALL)
    private List<PetSurrenderApplication> petSurrenderApplicationList;
}
