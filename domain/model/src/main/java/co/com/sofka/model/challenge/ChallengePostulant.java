package co.com.sofka.model.challenge;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class ChallengePostulant {
    private String idChallenge;
    private LocalDate registrationDate;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private String language;

    public ChallengePostulant(String idChallenge){
        this.idChallenge = idChallenge;
        this.registrationDate = LocalDate.now();
    }

    public ChallengePostulant(String idChallenge, String registrationDate, String initialDate, String finalDate, String language) {
        this.idChallenge = idChallenge;
        this.registrationDate = LocalDate.parse(registrationDate);
        this.initialDate = LocalDate.parse(initialDate);
        this.finalDate = LocalDate.parse(finalDate);
        this.language = language;
    }
}
