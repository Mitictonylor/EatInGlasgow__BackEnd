package EatInGlasgow.models;


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
    @JoinColumn(name = "customer_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Restaurant restaurant;

    @Column
    private int covers;

    public Booking(String date, String time, User user, Restaurant restaurant, int covers) {
        this.date = date;
        this.time = time;
        this.user = user;
        this.restaurant = restaurant;
        this.covers = covers;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public int getCovers() {
        return covers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setCovers(int covers) {
        this.covers = covers;
    }
}
