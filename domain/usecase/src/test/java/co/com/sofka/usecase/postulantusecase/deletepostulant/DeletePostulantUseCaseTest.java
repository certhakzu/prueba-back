package co.com.sofka.usecase.postulantusecase.deletepostulant;

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
class DeletePostulantUseCaseTest {

    @InjectMocks
    DeletePostulantUseCase deletePostulantUseCase;

    @Mock
    PostulantRepository postulantRepository;

    @Test
    void deletePostulant() {
        Postulant postulant = new Postulant("1", new DocumentUser(), "1990-02-10", "Colombiano",
                new Phone("57", "555555"), "1", "email@gmail.com");

        Mono<Void> voidMono = Mono.empty();
        when(postulantRepository.deleteById("1")).thenReturn(voidMono);

        StepVerifier.create(deletePostulantUseCase.deletePostulant("1"))
                .expectNextMatches(unused -> false)
                .expectNext();
    }
}