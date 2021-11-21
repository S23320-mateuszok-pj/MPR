package pl.edu.pjwstk.TripEvaluator;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
public class TripRestController {

    private final TripRepository tripRepository;
    private final ReviewRepository reviewRepository;

    public TripRestController(TripRepository repository, ReviewRepository reviewRepository) {
        this.tripRepository = repository;
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/saveTrip")
    public Trip saveTrip(Trip save){
        return tripRepository.save(save);
    }

    @PostMapping("saveReview")
    public Review saveReview(Review saveReview){
        return reviewRepository.save(saveReview);
    }

    @GetMapping("/findAll")
    public List<Trip> findAll(Trip findAll){
        return tripRepository.findAll();
    }

    @GetMapping("/findById{id}")
    public Optional<Trip> findById(@PathVariable Integer id){
        return tripRepository.findById(id);
    }

    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable Integer id){
        tripRepository.deleteById(id);
    }
}
