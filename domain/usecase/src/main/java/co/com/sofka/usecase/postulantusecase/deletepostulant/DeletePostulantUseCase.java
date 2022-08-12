package co.com.sofka.usecase.postulantusecase.deletepostulant;

import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeletePostulantUseCase {
    private final PostulantRepository postulantRepository;

    public Mono<Void> deletePostulant(String id){
        return postulantRepository.deleteById(id);
    }
}
