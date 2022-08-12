package co.com.sofka.usecase.trainingLeagueusecase.addtrainingleague;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AddTrainingLeagueUseCase {

    private final TrainingLeagueRepository repository;

    public Mono<TrainingLeague> addTrainingLeague(TrainingLeague trainingLeague) {
        return repository.save(trainingLeague);
    }
}
