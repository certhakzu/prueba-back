package co.com.sofka.usecase.postulantusecase.findallpostulant;

import co.com.sofka.model.postulant.DocumentUser;
import co.com.sofka.model.postulant.Phone;
import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;


import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllPostulantUseCaseTest {

    @InjectMocks
    FindAllPostulantUseCase findAllPostulantUseCase;

    @Mock
    PostulantRepository postulantRepository;

    @Test
    void findAllPostulant() {
        Postulant postulant1 = new Postulant("1", new DocumentUser(), "1990-02-10", "Peruano",
                new Phone("57", "555555"), "1", "email1@gmail.com");
        Postulant postulant2 = new Postulant("2", new DocumentUser(), "1990-10-10", "Boliviano",
                new Phone("57", "777777"), "2", "email2@gmail.com");

        Flux<Postulant> postulantFlux = Flux.fromIterable(List.of(postulant1, postulant2));
        when(postulantRepository.findAll()).thenReturn(postulantFlux);

        StepVerifier.create(findAllPostulantUseCase.findAllPostulant())
                .expectNextMatches(postulant -> postulant.getId().equals("1"))
                .expectNextMatches(postulant -> postulant.getId().equals("2"))
                .expectComplete()
                .verify();
    }
}