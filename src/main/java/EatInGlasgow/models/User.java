package EatInGlasgow.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String town;

    @Column
    private String postcode;

    @JsonBackReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Booking> restaurantBooked;

    @JsonBackReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Review> restaurantReviews;


    public User(String name, String surname, String email, String town, String postcode) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.town = town;
        this.postcode = postcode;
        this.restaurantBooked = new ArrayList<Booking>();
        this.restaurantReviews = new ArrayList<Review>();
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public List<Booking> getRestaurantBooked() {
        return restaurantBooked;
    }

    public void setRestaurantBooked(List<Booking> restaurantBooked) {
        this.restaurantBooked = restaurantBooked;
    }

    public List<Review> getRestaurantReviews() {
        return restaurantReviews;
    }

    public void setRestaurantReviews(List<Review> restaurantReviews) {
        this.restaurantReviews = restaurantReviews;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
