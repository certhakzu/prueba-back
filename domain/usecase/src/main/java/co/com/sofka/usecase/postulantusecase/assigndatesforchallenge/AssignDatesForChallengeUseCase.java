package co.com.sofka.usecase.postulantusecase.assigndatesforchallenge;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RequiredArgsConstructor
public class AssignDatesForChallengeUseCase {
    private final PostulantRepository postulantRepository;

    public Mono<Postulant> assignDatesForChallenge(String id, String initialDate, String finalDate){
        return postulantRepository.findById(id)
                .map(postulant -> {
                    var challenge = postulant.getChallenge();
                    challenge.setInitialDate(LocalDate.parse(initialDate));
                    challenge.setFinalDate(LocalDate.parse(finalDate));
                    postulant.setChallenge(challenge);
                    return postulant;
                }).flatMap(postulant -> postulantRepository.update(id, postulant));
    }
}
