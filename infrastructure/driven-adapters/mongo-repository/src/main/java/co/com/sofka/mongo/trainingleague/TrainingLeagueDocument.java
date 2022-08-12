package co.com.sofka.mongo.trainingleague;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TrainingLeagueDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private List<String> expecialities;
    private LocalDate dateConvocationEnd;
    private String img;
}
