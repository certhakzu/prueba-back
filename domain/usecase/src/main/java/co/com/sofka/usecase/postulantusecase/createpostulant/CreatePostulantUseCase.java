package co.com.sofka.usecase.postulantusecase.createpostulant;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreatePostulantUseCase {

    private final PostulantRepository postulantRepository;

    public Mono<Postulant> createPostulant(Postulant postulant){
        return postulantRepository.save(postulant);
    }
}
