package co.com.sofka.mongo.challenge;

import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.model.challenge.gateways.ChallengeRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ChallengeMongoRepositoryAdapter extends AdapterOperations<Challenge, ChallengeDocument, String, ChallengeMongoDBRepository>
implements ChallengeRepository
{

    public ChallengeMongoRepositoryAdapter(ChallengeMongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Challenge.class));
    }

    @Override
    public Mono<Challenge> update(String id, Challenge challenge) {
        return repository.save(new ChallengeDocument(
                id,
                challenge.getName(),
                challenge.getDescription(),
                challenge.getUrlDocument(),
                challenge.getClosingDate(),
                challenge.getLanguages()
        )).flatMap(challengeDocument -> Mono.just(challenge));
    }
}
