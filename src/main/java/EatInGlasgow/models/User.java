package EatInGlasgow.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
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



    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private List<Booking> bookings;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    private List<Review> reviews;


    public User(String name, String surname, String email, String town, String postcode) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.town = town;
        this.postcode = postcode;
        this.bookings = new ArrayList<Booking>();
        this.reviews = new ArrayList<Review>();
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
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

    public void addReviews(Review review){
        for(Booking booking : review.getRestaurant().getBookings()){
            if(booking.getUser() == review.getUser()){
            this.reviews.add(review);
            review.getRestaurant().addReview(review);}
    }}

    public void addBooking(Booking booking){
        LocalTime bookingTime = LocalTime.parse(booking.getTime());
        LocalTime restaurantOpenTime = LocalTime.parse(booking.getRestaurant().getOpeningTime());
        LocalTime restaurantCloseTime = LocalTime.parse(booking.getRestaurant().getClosingTime());
        int restCapacity = booking.getRestaurant().getCapacity();
        int dailyReservation = booking.getRestaurant().countBookingsParDay(booking.getDate());
        if( restCapacity >= (dailyReservation + booking.getCovers()) && bookingTime.isAfter(restaurantOpenTime) && bookingTime.isBefore(restaurantCloseTime)){
            this.bookings.add(booking);
             booking.getRestaurant().addBooking(booking);}
    }

    public int countBookings(){
        return this.bookings.size();
    }

    public int countReviews(){
        return this.reviews.size();
    }
}
