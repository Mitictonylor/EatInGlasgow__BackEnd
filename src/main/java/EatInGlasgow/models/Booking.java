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


}
