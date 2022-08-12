package co.com.sofka.usecase.postulantusecase.updatepostulant;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdatePostulantUseCase {
    private final PostulantRepository postulantRepository;

    public Mono<Postulant> updatePostulant(String id, Postulant postulant){
        return postulantRepository.update(id, postulant);
    }
}
