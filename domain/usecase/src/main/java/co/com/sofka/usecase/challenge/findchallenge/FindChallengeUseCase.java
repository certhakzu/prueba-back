package co.com.sofka.usecase.challenge.findchallenge;

import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.model.challenge.gateways.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindChallengeUseCase {
    private final ChallengeRepository challengeRepository;

    public Mono<Challenge> findChallenge(String id){
        return challengeRepository.findById(id);
    }
}
