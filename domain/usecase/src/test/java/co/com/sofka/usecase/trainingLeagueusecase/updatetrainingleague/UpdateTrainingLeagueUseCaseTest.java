package co.com.sofka.usecase.trainingLeagueusecase.updatetrainingleague;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateTrainingLeagueUseCaseTest {

    @InjectMocks
    UpdateTrainingLeagueUseCase updateTrainingLeagueUseCase;

    @Mock
    TrainingLeagueRepository trainingLeagueRepository;

    @Test
    void updateTrainingLeague() {

        TrainingLeague trainingLeague = new TrainingLeague("1", "Desarollo", "descripcion", List.of("") ,LocalDate.of(2022, 10, 10), "img");


        Mono<TrainingLeague> trainingLeagueMono = Mono.just(trainingLeague);
        when(trainingLeagueRepository.updateTrainingLeague("1", trainingLeague)).thenReturn(trainingLeagueMono);

        StepVerifier.create(updateTrainingLeagueUseCase.updateTrainingLeague("1", trainingLeague))
                .expectNextMatches(trainingLeague1 -> trainingLeague1.getId().equals("1"))
                .expectComplete()
                .verify();

    }
}