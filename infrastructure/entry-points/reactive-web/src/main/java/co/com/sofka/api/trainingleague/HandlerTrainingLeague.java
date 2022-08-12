package co.com.sofka.api.trainingleague;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.usecase.trainingLeagueusecase.addtrainingleague.AddTrainingLeagueUseCase;
import co.com.sofka.usecase.trainingLeagueusecase.deletetrainingleague.DeleteTrainingLeagueUseCase;
import co.com.sofka.usecase.trainingLeagueusecase.findalltrainingleague.FindAllTrainingLeagueUseCase;
import co.com.sofka.usecase.trainingLeagueusecase.findtrainingleague.FindTrainingLeagueUseCase;
import co.com.sofka.usecase.trainingLeagueusecase.updatetrainingleague.UpdateTrainingLeagueUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerTrainingLeague {

    private final AddTrainingLeagueUseCase addTrainingLeagueUseCase;

    private final FindAllTrainingLeagueUseCase findAllTrainingLeagueUseCase;
    private final FindTrainingLeagueUseCase findTrainingLeagueUseCase;
    private final UpdateTrainingLeagueUseCase updateTrainingLeagueUseCase;
    private final DeleteTrainingLeagueUseCase deleteTrainingLeagueUseCase;

    public Mono<ServerResponse> listenPostAddTrainingLeagueUseCase(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(TrainingLeague.class)
                .flatMap(trainingLeague -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(addTrainingLeagueUseCase.addTrainingLeague(trainingLeague), TrainingLeague.class));
    }

    public Mono<ServerResponse> listenFindAllTrainingLeagueUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findAllTrainingLeagueUseCase.findAllTrainingLeague(), TrainingLeague.class);
    }

    public Mono<ServerResponse> listenFindTrainingLeagueUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findTrainingLeagueUseCase.findTrainingLeague(id), TrainingLeague.class);
    }

    public Mono<ServerResponse> listenUpdateTrainingLeagueUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(TrainingLeague.class)
                .flatMap(trainingleague -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateTrainingLeagueUseCase.updateTrainingLeague(id, trainingleague),
                                TrainingLeague.class));
    }

    public Mono<ServerResponse> listenDeleteTrainingLeagueUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteTrainingLeagueUseCase.deletetrainingleague(id), TrainingLeague.class);
    }
}
