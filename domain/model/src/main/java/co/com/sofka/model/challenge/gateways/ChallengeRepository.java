package co.com.sofka.model.challenge.gateways;

import co.com.sofka.model.challenge.Challenge;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChallengeRepository {
    Mono<Challenge> save(Challenge challenge);

    Flux<Challenge> findAll();

    Mono<Challenge> findById(String id);

    Mono<Void> deleteById(String id);

    Mono<Challenge> update(String id, Challenge challenge);
}
