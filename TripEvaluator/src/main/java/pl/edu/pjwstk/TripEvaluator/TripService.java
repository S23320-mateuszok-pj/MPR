package pl.edu.pjwstk.TripEvaluator;

import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Optional<Trip> addReview(int id, Review saveReview ){
        try {
            tripRepository.findById(id).get().getReviews().add(saveReview);
            Optional<Trip> trip = tripRepository.findById(id);
            return Optional.of(tripRepository.save(trip.get()));
        } catch (NoResultException noResultException){
            return Optional.empty();
        }
    }
}
