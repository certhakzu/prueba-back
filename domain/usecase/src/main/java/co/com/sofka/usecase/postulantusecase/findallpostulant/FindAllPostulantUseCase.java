package co.com.sofka.usecase.postulantusecase.findallpostulant;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllPostulantUseCase {
    private final PostulantRepository postulantRepository;

    public Flux<Postulant> findAllPostulant(){
        return postulantRepository.findAll();
    }
}
