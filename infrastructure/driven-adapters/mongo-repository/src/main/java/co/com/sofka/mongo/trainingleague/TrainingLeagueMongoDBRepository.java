package co.com.sofka.mongo.trainingleague;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface TrainingLeagueMongoDBRepository
        extends ReactiveMongoRepository<TrainingLeagueDocument/* change for adapter model */, String>,
        ReactiveQueryByExampleExecutor<TrainingLeagueDocument/* change for adapter model */> {
}
