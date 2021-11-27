package pl.edu.pjwstk.TripEvaluator.models;

import pl.edu.pjwstk.TripEvaluator.models.Review;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String destination;
    private Double price;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Trip(){}

    public Trip(Integer id, String title, String destination, Double price, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.price = price;
        this.reviews = reviews;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", reviews=" + reviews +
                '}';
    }

}
