package co.com.sofka.mongo.postulant;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Repository
public class PostulantMongoRepositoryAdapter
    extends AdapterOperations<Postulant, PostulantDocument, String, PostulantMongoDBRepository>
    implements PostulantRepository {

  public PostulantMongoRepositoryAdapter(
      PostulantMongoDBRepository repository, ObjectMapper mapper) {
    super(repository, mapper, d -> mapper.map(d, Postulant.class));
  }

  @Override
  public Mono<Postulant> update(String id, Postulant postulant) {
    return repository
        .save(
            new PostulantDocument(
                id,
                postulant.getFullName(),
                postulant.getDocumentUser(),
                postulant.getDateOfBirth(),
                postulant.getNationality(),
                postulant.getUrlPhoto(),
                postulant.getPhone(),
                postulant.getEmail(),
                postulant.getCompanyName(),
                postulant.getWorkExperience(),
                postulant.getCurrentOccupation(),
                postulant.getEducationalLevel(),
                postulant.getCountry(),
                postulant.getDepartment(),
                postulant.getMunicipality(),
                postulant.getAddress(),
                postulant.getEnglishLevel(),
                postulant.getIsStudying(),
                postulant.getAboutYou(),
                postulant.getUrlCV(),
                postulant.getLinkedin(),
                postulant.getSessionOn(),
                postulant.getChallenge(),
                postulant.getIdTraining()))
        .flatMap(postulantDocument -> Mono.just(postulant));
  }

  @Override
  public Mono<Postulant> updatePostulantIsSession(Mono<Postulant> postulant1) {
    return postulant1
        .map(
            postulant -> {
              return repository
                  .save(
                      new PostulantDocument(
                          postulant.getId(),
                          postulant.getFullName(),
                          postulant.getDocumentUser(),
                          postulant.getDateOfBirth(),
                          postulant.getNationality(),
                          postulant.getUrlPhoto(),
                          postulant.getPhone(),
                          postulant.getEmail(),
                          postulant.getCompanyName(),
                          postulant.getWorkExperience(),
                          postulant.getCurrentOccupation(),
                          postulant.getEducationalLevel(),
                          postulant.getCountry(),
                          postulant.getDepartment(),
                          postulant.getMunicipality(),
                          postulant.getAddress(),
                          postulant.getEnglishLevel(),
                          postulant.getIsStudying(),
                          postulant.getAboutYou(),
                          postulant.getUrlCV(),
                          postulant.getLinkedin(),
                          postulant.getSessionOn(),
                          postulant.getChallenge(),
                          postulant.getIdTraining()))
                  .flatMap(postulantDocument -> Mono.just(postulant));
            })
        .flatMap(newPostuland -> newPostuland);
  }
}
