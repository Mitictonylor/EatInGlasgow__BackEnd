package EatInGlasgow.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @Column
    private String time;

    @ManyToOne
    @JsonIgnoreProperties(value = {"bookings", "reviews"})

    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JsonIgnoreProperties(value = {"bookings", "reviews"})

    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column
    private int covers;

    public Booking(String date, String time,  Restaurant restaurant, User user, int covers) {
        this.date = date;
        this.time = time;
        this.restaurant = restaurant;
        this.user = user;
        this.covers = covers;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getCovers() {
        return covers;
    }

    public void setCovers(int covers) {
        this.covers = covers;
    }
}
