package co.com.sofka.usecase.postulantusecase.updatepostulantissession;

import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdatePostulantIsSessionUseCase {
  private final PostulantRepository postulantRepository;

  public Mono<Postulant> updatePostulantIsSession(String id) {

    return postulantRepository.updatePostulantIsSession(postulantRepository
            .findById(id)
            .map(
                findPostulant -> {
                  return   new Postulant(
                          id,
                          findPostulant.getFullName(),
                          findPostulant.getDocumentUser(),
                          findPostulant.getDateOfBirth(),
                          findPostulant.getNationality(),
                          findPostulant.getUrlPhoto(),
                          findPostulant.getPhone(),
                          findPostulant.getEmail(),
                          findPostulant.getCompanyName(),
                          findPostulant.getWorkExperience(),
                          findPostulant.getCurrentOccupation(),
                          findPostulant.getEducationalLevel(),
                          findPostulant.getCountry(),
                          findPostulant.getDepartment(),
                          findPostulant.getMunicipality(),
                          findPostulant.getAddress(),
                          findPostulant.getEnglishLevel(),
                          findPostulant.getIsStudying(),
                          findPostulant.getAboutYou(),
                          findPostulant.getUrlCV(),
                          findPostulant.getLinkedin(),
                          !findPostulant.getSessionOn(),
                          findPostulant.getChallenge(),
                          findPostulant.getIdTraining());
                }));
  }
}
