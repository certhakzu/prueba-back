package co.com.sofka.mongo.postulant;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.sofka.model.challenge.ChallengePostulant;
import co.com.sofka.model.postulant.DocumentUser;
import co.com.sofka.model.postulant.FullName;
import co.com.sofka.model.postulant.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PostulantDocument {
    @Id
    private String id;
    private FullName fullName;
    private DocumentUser documentUser;
    private LocalDate dateOfBirth;
    private String nationality;
    private String urlPhoto;
    private Phone phone;
    private String email;
    private String companyName;
    private String workExperience;
    private String currentOccupation;
    private String educationalLevel;
    private String country;
    private String department;
    private String municipality;
    private String address;
    private String englishLevel;
    private String isStudying;
    private String aboutYou;
    private String urlCV;
    private String linkedin;
    private Boolean sessionOn;
    private ChallengePostulant challenge;
    private String idTraining;
}
