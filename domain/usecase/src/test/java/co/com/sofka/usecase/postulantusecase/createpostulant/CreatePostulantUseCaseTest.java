package co.com.sofka.usecase.postulantusecase.createpostulant;

import co.com.sofka.model.postulant.DocumentUser;
import co.com.sofka.model.postulant.Phone;
import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import co.com.sofka.usecase.postulantusecase.createpostulant.CreatePostulantUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreatePostulantUseCaseTest {

    @InjectMocks
    CreatePostulantUseCase createPostulantUseCase;

    @Mock
    PostulantRepository postulantRepository;

    @Test
    void createPostulant() {
        Postulant postulant = new Postulant("1", new DocumentUser(), "1990-02-10", "Colombiano",
                new Phone("57", "555555"), "1", "email@gmail.com");

        Mono<Postulant> postulantMono = Mono.just(postulant);
        when(postulantRepository.save(postulant)).thenReturn(postulantMono);

        StepVerifier.create(createPostulantUseCase.createPostulant(postulant))
                .expectNextMatches(postulant1 -> postulant1.getId().equals("1")
                        && postulant1.getDateOfBirth().equals(LocalDate.parse("1990-02-10"))
                        && postulant1.getIdTraining().equals("1"))
                .expectComplete()
                .verify();
    }
}