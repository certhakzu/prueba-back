package co.com.sofka.usecase.challenge.updatechallenge;

import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.model.challenge.gateways.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateChallengeUseCase {
    private final ChallengeRepository challengeRepository;

    public Mono<Challenge> updateChallenge(String id, Challenge challenge){
        return challengeRepository.update(id, challenge);
    }
}
