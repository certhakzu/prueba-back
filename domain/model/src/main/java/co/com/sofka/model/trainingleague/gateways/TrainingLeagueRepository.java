package co.com.sofka.model.trainingleague.gateways;

import co.com.sofka.model.trainingleague.TrainingLeague;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TrainingLeagueRepository {
    Mono<TrainingLeague> save(TrainingLeague trainingleague);

    Flux<TrainingLeague> findAll();

    Mono<TrainingLeague> findById(String id);

    Mono<Void> deleteById(String id);

    Mono<TrainingLeague> updateTrainingLeague(String id, TrainingLeague trainingLeague);
}
