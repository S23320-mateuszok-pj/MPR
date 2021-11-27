package pl.edu.pjwstk.TripEvaluator.controllers;

import com.sun.xml.bind.v2.TODO;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.TripEvaluator.repository.TripRepository;
import pl.edu.pjwstk.TripEvaluator.models.Review;
import pl.edu.pjwstk.TripEvaluator.models.Trip;
import pl.edu.pjwstk.TripEvaluator.service.TripService;

import java.util.List;
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

    @PostMapping("/saveReview/{id}") //TODO change @PathVariable to @RequestParam in saveReview
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

    //TODO poczytać o mokito
}
