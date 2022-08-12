package co.com.sofka.model.postulant;

import co.com.sofka.model.challenge.ChallengePostulant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Postulant {
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

    public Postulant(String id, DocumentUser documentUser, String dateOfBirth, String nationality, String urlPhoto,
            Phone phone, String email, String workExperience, String currentOccupation, String educationalLevel,
            String country, String department, String municipality, String address, String englishLevel,
            String isStudying, String aboutYou, String urlCV, String linkedin, Boolean sessionOn,
            ChallengePostulant challenge, String idTraining) {
        this.id = id;
        this.documentUser = documentUser;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.nationality = nationality;
        this.urlPhoto = urlPhoto;
        this.phone = phone;
        this.email = email;
        this.workExperience = workExperience;
        this.currentOccupation = currentOccupation;
        this.educationalLevel = educationalLevel;
        this.country = country;
        this.department = department;
        this.municipality = municipality;
        this.address = address;
        this.englishLevel = englishLevel;
        this.isStudying = isStudying;
        this.aboutYou = aboutYou;
        this.urlCV = urlCV;
        this.linkedin = linkedin;
        this.sessionOn = sessionOn;
        this.challenge = challenge;
        this.idTraining = idTraining;
    }

    public Postulant(String id, LocalDate dateOfBirth, ChallengePostulant challenge) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.challenge = challenge;
    }

    public Postulant(String id, DocumentUser documentUser, String dateOfBirth, String nationality, Phone phone,
                     String idTraining, String email) {
        this.id = id;
        this.documentUser = documentUser;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.nationality = nationality;
        this.phone = phone;
        this.idTraining = idTraining;
        this.email = email;
    }

    public void setChallengeId(String idChallenge) {
        this.challenge.setIdChallenge(idChallenge);
    }
}
