package co.com.sofka.usecase.trainingLeagueusecase.findtrainingleague;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindTrainingLeagueUseCase {
    private final TrainingLeagueRepository repository;

    public Mono<TrainingLeague> findTrainingLeague(String id) {
        return repository.findById(id);
    }
}
