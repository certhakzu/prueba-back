package co.com.sofka.usecase.postulantusecase.calculateage;


import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RequiredArgsConstructor
public class CalculateAgeUseCase {
    private final PostulantRepository postulantRepository;

    public Mono<Integer> calculateAge(String datePostulant) {
        LocalDate dateOfBirth = LocalDate.parse(datePostulant);

        return Mono.just(LocalDate.now().getYear() - dateOfBirth.getYear());

    }
}
