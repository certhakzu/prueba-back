package co.com.sofka.api.postulant;



import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.usecase.challenge.choosechallengerandom.ChooseChallengeRandomUseCase;
import co.com.sofka.usecase.postulantusecase.addchallenge.AddChallengeUseCase;
import co.com.sofka.usecase.postulantusecase.assigndatesforchallenge.AssignDatesForChallengeUseCase;
import co.com.sofka.usecase.postulantusecase.calculateage.CalculateAgeUseCase;
import co.com.sofka.usecase.postulantusecase.createpostulant.CreatePostulantUseCase;
import co.com.sofka.usecase.postulantusecase.deletepostulant.DeletePostulantUseCase;
import co.com.sofka.usecase.postulantusecase.findallpostulant.FindAllPostulantUseCase;
import co.com.sofka.usecase.postulantusecase.findpostulant.FindPostulantUseCase;
import co.com.sofka.usecase.postulantusecase.findwhostartstoday.FindWhoStartsTodayUseCase;
import co.com.sofka.usecase.postulantusecase.issessionon.IsSessionOnUseCase;
import co.com.sofka.usecase.postulantusecase.registertotraining.RegisterToTrainingUseCase;
import co.com.sofka.usecase.postulantusecase.updatepostulant.UpdatePostulantUseCase;
import co.com.sofka.usecase.postulantusecase.updatepostulantissession.UpdatePostulantIsSessionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class HandlerPostulant {

    private final CreatePostulantUseCase createPostulantUseCase;
    private final DeletePostulantUseCase deletePostulantUseCase;
    private final FindAllPostulantUseCase findAllPostulantUseCase;
    private final FindPostulantUseCase findPostulantUseCase;
    private final UpdatePostulantUseCase updatePostulantUseCase;
    private final RegisterToTrainingUseCase registerToTrainingUseCase;
    private final AddChallengeUseCase addChallengeUseCase;
    private final CalculateAgeUseCase calculateAgeUseCase;
    private final IsSessionOnUseCase isSessionOnUseCase;
    private final FindWhoStartsTodayUseCase findWhoStartsTodayUseCase;
    private final AssignDatesForChallengeUseCase assignDatesForChallengeUseCase;



    private final UpdatePostulantIsSessionUseCase updatePostulantIsSessionUseCase;

    public Mono<ServerResponse> listenPostCreatePostulantUseCase(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Postulant.class)
                .flatMap(postulant -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createPostulantUseCase.createPostulant(postulant), Postulant.class));
    }

    public Mono<ServerResponse> listenDeletePostulant(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deletePostulantUseCase.deletePostulant(id), Postulant.class);
    }

    public Mono<ServerResponse> listenGetFindAllPostulant(ServerRequest serverRequest){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findAllPostulantUseCase.findAllPostulant(), Postulant.class);
    }

    public Mono<ServerResponse> listenGetFindPostulant(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findPostulantUseCase.findPostulant(id), Postulant.class);
    }

    public Mono<ServerResponse> listenUpdatePostulantIsSessionUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(updatePostulantIsSessionUseCase.updatePostulantIsSession(id), Postulant.class);
    }

    public Mono<ServerResponse> listenPutUpdatePostulant(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Postulant.class)
                .flatMap(postulant -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updatePostulantUseCase.updatePostulant(id, postulant), Postulant.class));
    }

    public Mono<ServerResponse> listenPutRegisterToTrainingUseCase(ServerRequest serverRequest){
        var idTraining = serverRequest.pathVariable("idTraining");
        var idPostulant = serverRequest.pathVariable("idPostulant");
        return  ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(registerToTrainingUseCase.registerToTraining(idTraining, idPostulant), Postulant.class);
    }

    public Mono<ServerResponse> listenGetAddChallengeUseCase(ServerRequest serverRequest){
        var idChallenge = serverRequest.pathVariable("idChallenge");
        var idPostulant = serverRequest.pathVariable("idPostulant");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(addChallengeUseCase.addChallenge(idPostulant, idChallenge), Postulant.class);
    }

    public Mono<ServerResponse> listenGetCalculateAgeUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(calculateAgeUseCase.calculateAge(id), Integer.class);
    }

    public Mono<ServerResponse> listenGetIsSessionOnUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(isSessionOnUseCase.isSessionOn(id), Boolean.class);
    }

    public Mono<ServerResponse> listenGetFindWhoStartsTodayUseCase(ServerRequest serverRequest){
        var date = serverRequest.pathVariable("date");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findWhoStartsTodayUseCase.findWhoStartToday(date), Postulant.class);
    }

    public Mono<ServerResponse> listenGetAssignDatesForChallengeUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        var initialDate = serverRequest.pathVariable("initial");
        var finalDate = serverRequest.pathVariable("final");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(assignDatesForChallengeUseCase.assignDatesForChallenge(id, initialDate, finalDate), Postulant.class);
    }

    /*public Mono<ServerResponse> listenPostSendMailUseCase(ServerRequest serverRequest){
        return serverRequest
                .bodyToMono(SimpleMail.class)
                .flatMap(simpleMail -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(sendMailUseCase.send(simpleMail), SimpleMail.class));
    }*/
}
