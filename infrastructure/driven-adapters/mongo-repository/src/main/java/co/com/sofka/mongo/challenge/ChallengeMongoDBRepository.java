package co.com.sofka.mongo.challenge;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;


public interface ChallengeMongoDBRepository extends ReactiveMongoRepository<ChallengeDocument, String>, ReactiveQueryByExampleExecutor<ChallengeDocument> {
}
