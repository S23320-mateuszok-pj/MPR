package pl.edu.pjwstk.TripEvaluator;

import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/trip")
public class TripRestController {

    private final TripRepository tripRepository;
    private final TripService tripService;

    public TripRestController(TripRepository repository, TripService tripService) {
        this.tripRepository = repository;
        this.tripService = tripService;
    }

    @PostMapping("/saveTrip")
    public Trip saveTrip(@RequestBody Trip save){
        return tripRepository.save(save);
    }

    @PostMapping("saveReview/{id}")
    public Optional<Trip> saveReview(@PathVariable Integer id , @RequestBody Review saveReview){
            return tripService.addReview(id, saveReview);
    }

    @GetMapping("/findAll")
    public List<Trip> findAll(Trip findAll){
        return tripRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Optional<Trip> findById(@PathVariable Integer id){
        return tripRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        tripRepository.deleteById(id);
    }
}
