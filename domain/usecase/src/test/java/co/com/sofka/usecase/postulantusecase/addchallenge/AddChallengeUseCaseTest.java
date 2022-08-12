package co.com.sofka.usecase.postulantusecase.addchallenge;

import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.model.postulant.DocumentUser;
import co.com.sofka.model.postulant.Phone;
import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.mockito.Mockito.when;


class AddChallengeUseCaseTest {

    @InjectMocks
    AddChallengeUseCase addChallengeUseCase;

    @Mock
    PostulantRepository postulantRepository;

    @Test
    void addChallenge() {
        Postulant postulant = new Postulant("1", new DocumentUser("CC", "123456789"), "1990-02-10", "Colombiano",
                new Phone("57", "5555555"), "1", "email@gmail.com");
        /*Challenge challenge = new Challenge("1", "nombre", "descripcion", "documento.pdf",
                LocalDate.parse("2022-10-10"));*/

        /*Mono<Challenge> challengeMono = Mono.just(challenge);*/
        Mono<Postulant> postulantMono = Mono.just(postulant);
        when(postulantRepository.update("1", postulant)).thenReturn(postulantMono);

        StepVerifier.create(addChallengeUseCase.addChallenge("1", "1"))
                .expectNextMatches(postulant1 -> postulant1.getId().equals("1"))
                .expectComplete()
                .verify();
    }
}