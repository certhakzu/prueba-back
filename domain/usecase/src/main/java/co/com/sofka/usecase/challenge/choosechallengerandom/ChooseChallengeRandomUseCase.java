package co.com.sofka.usecase.challenge.choosechallengerandom;

import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.model.challenge.gateways.ChallengeRepository;
import co.com.sofka.usecase.challenge.findallchallenge.FindAllChallengeUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RequiredArgsConstructor
public class ChooseChallengeRandomUseCase {
    private final ChallengeRepository challengeRepository;
    private final FindAllChallengeUseCase findAllChallengeUseCase;

    public Mono<Challenge> chooseChallengeRandom(){
        return challengeRepository.findAll().collectList().map(challenges -> {
            var challengesList = challenges;
            Collections.shuffle(challengesList);
            return challengesList.get(0);
        });
    }
}
