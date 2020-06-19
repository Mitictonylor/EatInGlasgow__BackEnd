package EatInGlasgow.models;


import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Restaurant restaurant;

    @Column
    private int rate;

    public Review(String date, User user, Restaurant restaurant, int rate) {
        this.date = date;
        this.user = user;
        this.restaurant = restaurant;
        this.rate = rate;
    }

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public int getRate() {
        return rate;
    }
}
