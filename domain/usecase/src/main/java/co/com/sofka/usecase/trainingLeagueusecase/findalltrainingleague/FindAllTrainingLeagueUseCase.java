package co.com.sofka.usecase.trainingLeagueusecase.findalltrainingleague;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllTrainingLeagueUseCase {
    private final TrainingLeagueRepository repository;

    public Flux<TrainingLeague> findAllTrainingLeague() {
        return repository.findAll();
    }
}
