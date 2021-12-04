package pl.edu.pjwstk.TripEvaluator.service;

import org.junit.jupiter.api.Test;
import pl.edu.pjwstk.TripEvaluator.models.Trip;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TripServiceTest {

     private TripService tripService = new TripService(null);


    @Test
    void checkTheTitleIsEmpty(){
        //given
        Trip trip = new Trip(1,"","test test",100.00, List.of());
        //when
        tripService.emptyTitle(trip);
        //then
        assertThat(trip.getTitle()).isEqualTo("empty");
    }
    @Test
    void checkTheTitleIsNull(){
        //given
        Trip trip = new Trip(1,null,"test test",100.00, List.of());
        //when
        tripService.emptyTitle(trip);
        //then
        assertThat(trip.getTitle()).isEqualTo("empty");
    }

    @Test
    void checkTheDestinationIsEmpty(){
        Trip trip = new Trip(1,"Test","",100.00, List.of());
        tripService.emptyDestination(trip);
        assertThat(trip.getDestination()).isEqualTo("empty");
    }

    @Test
    void checkTheDestinationIsNull(){
        Trip trip = new Trip(1,"Test",null,100.00, List.of());
        tripService.emptyDestination(trip);
        assertThat(trip.getDestination()).isEqualTo("empty");
    }

    @Test
    void changePriceFromMinusToZero(){
        Trip trip = new Trip(1,"Test","null",-100.00, List.of());
        tripService.minusPrice(trip);
        assertThat(trip.getPrice()).isEqualTo(0);
    }

    @Test
    void changeTitleToLowerCase(){
        Trip trip = new Trip(1,"QWERTY","null",-100.00, List.of());
        tripService.changeTitleToLowerCase(trip);
        assertThat(trip.getTitle()).isEqualTo("qwerty");
    }

//    @Test
//    void checkTheReviewsIsEmpty(){
//        Trip trip = new Trip(1,"QWERTY","null",-100.00, List.of());
//
//        tripService.emptyReviews(trip,);
//    }
}
