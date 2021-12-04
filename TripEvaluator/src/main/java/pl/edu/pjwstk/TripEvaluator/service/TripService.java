package pl.edu.pjwstk.TripEvaluator.service;

import org.springframework.stereotype.Service;
import pl.edu.pjwstk.TripEvaluator.models.Review;
import pl.edu.pjwstk.TripEvaluator.models.Trip;
import pl.edu.pjwstk.TripEvaluator.repository.TripRepository;

import javax.persistence.NoResultException;
import java.util.Locale;
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

    public void emptyTitle(Trip trip){
        if(trip.getTitle()== null || trip.getTitle().isBlank())
            trip.setTitle("empty");
    }

    public void emptyDestination(Trip trip){
        if (trip.getDestination() == null || trip.getDestination().isBlank())
            trip.setDestination("empty");
    }

    public void minusPrice(Trip trip){
        if(trip.getPrice() < 0){
            trip.setPrice(0.0);
        }
    }

    public void changeTitleToLowerCase(Trip trip){
        trip.setTitle(trip.getTitle().toLowerCase(Locale.getDefault()));
    }

    public void emptyReviews(Trip trip, Review review){
        if(trip.getReviews().isEmpty()){
            trip.getReviews().add(review);
        }
    }

    //TODO create more complicate methods
}
