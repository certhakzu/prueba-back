package co.com.sofka.usecase.postulantusecase.issessionon;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class IsSessionOnUseCase {
    private final PostulantRepository postulantRepository;

    public Mono<Boolean> isSessionOn(String id){
        return postulantRepository.findById(id)
                .map(Postulant::getSessionOn).flatMap(aBoolean -> Mono.just(aBoolean.booleanValue()));
    }
}
