package co.com.sofka.usecase.postulantusecase.assigndatesforchallenge;

import co.com.sofka.model.challenge.ChallengePostulant;
import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssignDatesForChallengeUseCaseTest {
    @InjectMocks
    AssignDatesForChallengeUseCase assignDatesForChallengeUseCase;

    @Mock
    PostulantRepository postulantRepository;

    @Test
    void assignDatesForChallenge() {
        Postulant postulant = new Postulant(
                "1",
                LocalDate.parse("1990-02-10"),
                new ChallengePostulant("1", "2022-08-08", "2022-08-10", "2022-08-12", "python"));

        Mono<Postulant> postulantMono = Mono.just(postulant);
        when(postulantRepository.save(postulant)).thenReturn(postulantMono);

        StepVerifier.create(assignDatesForChallengeUseCase.assignDatesForChallenge("1", "2022-08-10", "2022-08-12"))
                .expectNextMatches(postulant1 -> postulant1.getChallenge().getInitialDate().equals(LocalDate.parse("2022-08-10")))
                .expectComplete()
                .verify();
    }
}