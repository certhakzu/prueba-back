package co.com.sofka.usecase.challenge.createchallenge;

import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.model.challenge.gateways.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateChallengeUseCase {
    private final ChallengeRepository challengeRepository;

    public Mono<Challenge> createChallenge(Challenge challenge){
        return challengeRepository.save(challenge);
    }
}
