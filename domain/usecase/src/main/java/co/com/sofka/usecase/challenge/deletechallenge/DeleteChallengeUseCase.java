package co.com.sofka.usecase.challenge.deletechallenge;

import co.com.sofka.model.challenge.gateways.ChallengeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteChallengeUseCase {
    private final ChallengeRepository challengeRepository;

    public Mono<Void> deleteChallenge(String id){
        return challengeRepository.deleteById(id);
    }
}
