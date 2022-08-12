package co.com.sofka.mongo.trainingleague;

import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import co.com.sofka.mongo.trainingleague.TrainingLeagueDocument;
import co.com.sofka.mongo.trainingleague.TrainingLeagueMongoDBRepository;


import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import reactor.core.publisher.Mono;

@Repository
public class TrainingLeagueMongoRepositoryAdapter extends
                AdapterOperations<TrainingLeague, TrainingLeagueDocument, String, TrainingLeagueMongoDBRepository>
                implements TrainingLeagueRepository {

        public TrainingLeagueMongoRepositoryAdapter(TrainingLeagueMongoDBRepository repository, ObjectMapper mapper) {
                /**
                 * Could be use mapper.mapBuilder if your domain model implement builder pattern
                 * super(repository, mapper, d ->
                 * mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
                 * Or using mapper.map with the class of the object model
                 */
                super(repository, mapper, d -> mapper.map(d, TrainingLeague.class/* change for domain model */));
        }

        @Override
        public Mono<TrainingLeague> updateTrainingLeague(String id, TrainingLeague trainingLeague) {
                return repository.save(
                                new TrainingLeagueDocument(
                                                id,
                                                trainingLeague.getName(),
                                                trainingLeague.getDescription(),
                                                trainingLeague.getExpecialities(),
                                                trainingLeague.getDateConvocationEnd(),
                                                trainingLeague.getImg()))
                                .flatMap(element -> Mono.just(trainingLeague));
        }
}
