package co.com.sofka.mongo.challenge;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

@Document
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ChallengeDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private String urlDocument;
    private LocalDate closingDate;
    private Set<String> languages;
}
