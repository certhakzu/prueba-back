package co.com.sofka.usecase.challenge.findallchallenge;

import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.model.challenge.gateways.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;


@RequiredArgsConstructor
public class FindAllChallengeUseCase {
    private final ChallengeRepository challengeRepository;

    public Flux<Challenge> findAllChallenge(){
        return challengeRepository.findAll();
    }
}
