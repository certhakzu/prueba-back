package co.com.sofka.usecase.trainingLeagueusecase.updatetrainingleague;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateTrainingLeagueUseCase {

    private final TrainingLeagueRepository repository;

    public Mono<TrainingLeague> updateTrainingLeague(String id, TrainingLeague trainingLeague) {

        return repository.updateTrainingLeague(id, trainingLeague);

    }

}
