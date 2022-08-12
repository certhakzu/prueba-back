package co.com.sofka.usecase.trainingLeagueusecase.deletetrainingleague;

import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteTrainingLeagueUseCase {
    private final TrainingLeagueRepository repository;

    public Mono<Void> deletetrainingleague(String id) {
        return repository.deleteById(id);
    }
}
