package co.com.sofka.api.challenge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterRestChallenge {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionChallenge(HandlerChallenge handler) {
        return route(POST("/api/challenge"), handler::listenPostCreateChallengeUseCase)
                .andRoute(DELETE("/api/challenge/{id}"), handler::listenDeleteChallengeUseCase)
                .andRoute(GET("/api/challenge"), handler::listenGetFindAllChallengeUseCase)
                .andRoute(GET("/api/challenge/{id}"), handler::listenGetFindChallengeUseCase)
                .andRoute(PUT("/api/challenge/{id}"), handler::listenPutUpdateChallengeUseCase)
                .andRoute(GET("/api/chooserandom"), handler::listenGetChooseChallengeRandomUseCase);
    }
}
