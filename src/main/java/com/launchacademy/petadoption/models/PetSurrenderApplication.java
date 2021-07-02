package com.launchacademy.petadoption.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pet_surrender_applications")
@NoArgsConstructor
@Getter
@Setter

public class PetSurrenderApplication {
    @Id
    @SequenceGenerator(name = "pet_surrender_application_generator", sequenceName = "pet_surrender_applications_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_surrender_application_generator")
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @NotNull(message = "Please enter your name")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Please enter your phone number")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "pet_name", nullable = false)
    private String petName;

    @Column(name = "pet_age")
    private Integer petAge;

    @URL (message = "please provide the link to the picture")
    @Column(name = "pet_image_url", nullable = false)
    private String petImgUrl;

    @Column(name = "vaccination_status")
    private Boolean vaccinationStatus;

    @NotNull
    @Column(name = "application_status", nullable = false)
    private String applicationStatus;

    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    @JsonIgnoreProperties("petSurrenderApplicationList")
    private PetType petType;
}
