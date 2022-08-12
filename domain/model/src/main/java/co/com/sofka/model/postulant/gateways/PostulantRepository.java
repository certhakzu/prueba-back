package co.com.sofka.model.postulant.gateways;

import co.com.sofka.model.postulant.Postulant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostulantRepository {
    Mono<Postulant> save(Postulant postulant);

    Flux<Postulant> findAll();

    Mono<Postulant> findById(String id);

    Mono<Void> deleteById(String id);

    Mono<Postulant> update(String id, Postulant postulant);

    Mono<Postulant> updatePostulantIsSession(Mono<Postulant> postulant);
}
