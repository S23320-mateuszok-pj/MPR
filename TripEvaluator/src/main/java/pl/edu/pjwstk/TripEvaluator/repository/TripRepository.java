package pl.edu.pjwstk.TripEvaluator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjwstk.TripEvaluator.models.Trip;

public interface TripRepository extends JpaRepository<Trip,Integer> {
}
