package co.com.sofka.usecase.postulantusecase.findpostulant;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindPostulantUseCase {
    private final PostulantRepository postulantRepository;

    public Mono<Postulant> findPostulant(String id){
        return postulantRepository.findById(id);
    }
}
