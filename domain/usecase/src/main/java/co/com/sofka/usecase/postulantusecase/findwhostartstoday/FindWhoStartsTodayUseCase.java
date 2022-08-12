package co.com.sofka.usecase.postulantusecase.findwhostartstoday;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class FindWhoStartsTodayUseCase {
    private final PostulantRepository postulantRepository;
    final Logger logger = Logger.getLogger("Logger");

    public Flux<String> findWhoStartToday(String date){
        var searchedDate = LocalDate.parse(date);
        return postulantRepository.findAll()
                .filter(postulant -> postulant.getChallenge().getInitialDate().equals(searchedDate))
                .onErrorContinue((throwable, o) -> logger.info(throwable.getMessage()))
                .map(Postulant::getEmail);
    }
}
