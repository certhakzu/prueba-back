package co.com.sofka.usecase.trainingLeagueusecase.findalltrainingleague;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class FindAllTrainingLeagueUseCaseTest {

    @InjectMocks
    FindAllTrainingLeagueUseCase findAllTrainingLeagueUseCase;

    @Mock
    TrainingLeagueRepository trainingLeagueRepository;

    @Test
    void findAllTrainingLeague() {


        TrainingLeague trainingLeague1 = new TrainingLeague("1", "Desarollo", "descripcion", List.of("") ,LocalDate.of(2022, 10, 10), "img");
        TrainingLeague trainingLeague2 = new TrainingLeague("2", "Desarollo2", "descripcion", List.of("") ,LocalDate.of(2022, 10, 10), "img");




        Flux<TrainingLeague> trainingLeagueFlux = Flux.fromIterable(List.of(trainingLeague1, trainingLeague2));
        when(trainingLeagueRepository.findAll()).thenReturn(trainingLeagueFlux);

        StepVerifier.create(findAllTrainingLeagueUseCase.findAllTrainingLeague())
                .expectNextMatches(trainingLeague -> trainingLeague.getId().equals("1"))
                .expectNextMatches(trainingLeague -> trainingLeague.getId().equals("2"))
                .verifyComplete();
    }
}