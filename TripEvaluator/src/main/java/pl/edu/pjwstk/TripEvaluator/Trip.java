package pl.edu.pjwstk.TripEvaluator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String destination;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Trip(){}

    public Trip(Integer id, String title, String destination, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.destination = destination;
        this.reviews = reviews;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDestination() {
        return destination;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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
                ", reviews=" + reviews +
                '}';
    }
}
