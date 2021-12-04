package pl.edu.pjwstk.TripEvaluator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pjwstk.TripEvaluator.models.Trip;
import pl.edu.pjwstk.TripEvaluator.service.TripService;

import java.util.List;

@SpringBootApplication
public class TripEvaluatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripEvaluatorApplication.class, args);

	}
}
