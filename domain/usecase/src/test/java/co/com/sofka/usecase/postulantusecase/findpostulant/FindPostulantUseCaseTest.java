package co.com.sofka.usecase.postulantusecase.findpostulant;

import co.com.sofka.model.postulant.DocumentUser;
import co.com.sofka.model.postulant.Phone;
import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindPostulantUseCaseTest {
    @InjectMocks
    FindPostulantUseCase findPostulantUseCase;

    @Mock
    PostulantRepository postulantRepository;

    @Test
    void findPostulant() {
        Postulant postulant = new Postulant("1", new DocumentUser(), "1990-02-10", "Peruano",
                new Phone("57", "555555"), "1", "email@gmail.com");

        Mono<Postulant> postulantMono = Mono.just(postulant);
        when(postulantRepository.findById("1")).thenReturn(postulantMono);

        StepVerifier.create(findPostulantUseCase.findPostulant("1"))
                .expectNextMatches(postulant1 -> postulant1.getId().equals("1"))
                .verifyComplete();
    }
}