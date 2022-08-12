package co.com.sofka.api.trainingleague;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(HandlerTrainingLeague handler) {
        return route(POST("/api/trainingleague"), handler::listenPostAddTrainingLeagueUseCase)
                .andRoute(GET("/api/trainingleague"), handler::listenFindAllTrainingLeagueUseCase)
                .andRoute(GET("/api/trainingleague/{id}"), handler::listenFindTrainingLeagueUseCase)
                .andRoute(PUT("/api/trainingleague/{id}"), handler::listenUpdateTrainingLeagueUseCase)
                .andRoute(DELETE("/api/trainingleague/{id}"), handler::listenDeleteTrainingLeagueUseCase);
    }
}
