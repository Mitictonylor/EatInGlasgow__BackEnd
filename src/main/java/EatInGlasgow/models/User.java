package EatInGlasgow.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="users")
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

//    @JsonBackReference
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Booking> restaurantBooked

  //  @JsonBackReference
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Review> restaurantReviews


    public User(String name, String surname, String email, String town, String postcode) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.town = town;
        this.postcode = postcode;
//        this.restaurantBooked = new ArrayList<Booking>();
//        this.restaurantReviews = new ArrayList<Review>();
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getTown() {
        return town;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
