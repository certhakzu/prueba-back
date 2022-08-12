package co.com.sofka.usecase.postulantusecase.addchallenge;

import co.com.sofka.model.challenge.ChallengePostulant;
import co.com.sofka.model.challenge.gateways.ChallengeRepository;
import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Collections;


@RequiredArgsConstructor
public class AddChallengeUseCase {
    private final PostulantRepository postulantRepository;


    public Mono<Postulant> addChallenge(String idPostulant, String idChallenge){
        return postulantRepository.findById(idPostulant)
                .map(postulant -> {
                    postulant.setChallengeId(idChallenge);
                    return postulant;
                }).flatMap(postulant -> postulantRepository.update(idPostulant, postulant));
    }
}
