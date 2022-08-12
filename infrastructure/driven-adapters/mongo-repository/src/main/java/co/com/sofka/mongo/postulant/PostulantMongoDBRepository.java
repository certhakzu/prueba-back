package co.com.sofka.mongo.postulant;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface PostulantMongoDBRepository extends ReactiveMongoRepository<PostulantDocument, String>, ReactiveQueryByExampleExecutor<PostulantDocument> {
}
