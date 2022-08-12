package co.com.sofka.usecase.postulantusecase.registertotraining;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class RegisterToTrainingUseCase {
    private final PostulantRepository postulantRepository;

    public Mono<Postulant> registerToTraining(String idTraining, String idPostulant){

        return postulantRepository.findById(idPostulant)
                .map(postulant -> {
                    postulant.setIdTraining(idTraining);
                    return postulant;
                }).flatMap(postulant -> postulantRepository.update(idPostulant, postulant));
    }
}
