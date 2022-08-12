package co.com.sofka;

import co.com.sofka.usecase.postulantusecase.findwhostartstoday.FindWhoStartsTodayUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;



@EnableScheduling
@Component
@RequiredArgsConstructor
public class SentinelPostulant implements CommandLineRunner {

    @Autowired
    private JavaMailSender emailSender;
    private final FindWhoStartsTodayUseCase findWhoStartsTodayUseCase;

    @Scheduled(cron = "0 0 0 * * ?")
    public Mono<Void> verifyOnHOurEspecify() throws Exception {
        System.out.println("A UNA HORA ESPECIFICA");

        var now = LocalDate.now();
        try{
            String year = String.valueOf(now.getYear());
            String month = String.valueOf(now.getMonthValue());
            if (month.length() == 1){
                month = "0" + month;
            }
            String day = String.valueOf(now.getDayOfMonth());
            if (day.length() == 1){
                day = "0" + day;
            }
            String today = year +"-"+ month +"-"+ day;
            var emails = findWhoStartsTodayUseCase.findWhoStartToday(today).collectList().block();

            System.out.println(emails);
            System.out.println(today);
            String[] arrayEmails = new String[emails.size()];

            emails.forEach(s -> {
                try {
                    run(s);
                } catch (Exception e) {
                    System.out.println("ERROR AL INTENTAR ITERAR LOS EMAILS");/*throw new RuntimeException(e);*/
                }
            });
            //run(arrayEmails); /*"pealveco@gmail.com", "pealveco@yahoo.com"*/
        } catch (DateTimeParseException dateTimeParseException){
            System.out.println("ERRRORRRRRRRRRR");
        }
        return Mono.empty();
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(args).forEach(s -> {
            var bodyMessage = "Cordial Saludo, de parte de Sofka U le queremos recordar que hoy empiezan sus 3 días de realización de Reto" +
                    " le deseamos exitos de parte de SOFKA TECHNOLOGIES";
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("sofkaprueba111@gmail.com");
            message.setTo(s);
            message.setSubject("Aviso de inicio de Reto - Su Reto Inicia hoy - EXITOS");
            message.setText(bodyMessage);
            emailSender.send(message);
        });
    }
}
