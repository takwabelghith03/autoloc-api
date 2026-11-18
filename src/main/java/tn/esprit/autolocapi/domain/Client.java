package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClient;

    @NotBlank
    String nom;

    @NotBlank
    String prenom;

    @Email
    String email;

    String telephone;

    @NotBlank
    String numPermis;

    LocalDate dateInscription;
}