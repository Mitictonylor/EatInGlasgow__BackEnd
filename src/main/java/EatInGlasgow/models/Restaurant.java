package EatInGlasgow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String pictureUrl;

    @Column
    private int capacity;

    @Column(name = "price_range")
    private String priceRange;

    @Column
    private String cousine;

    @Column
    private int discount;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String postcode;

    @Column
    private String town;

    @Column(name = "opening_time")
    private String openingTime;

    @Column(name = "closing_time")
    private String closingTime;

    @JsonBackReference(value="bookings")
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    private List<Booking> bookings;

    @JsonBackReference(value="reviews")
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Restaurant(String name, String pictureUrl, int capacity, String priceRange, String cousine, int discount, String email, String address, String postcode, String town, String openingTime, String closingTime) {
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.capacity = capacity;
        this.priceRange = priceRange;
        this.cousine = cousine;
        this.discount = discount;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.town = town;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.bookings = new ArrayList<Booking>();
        this.reviews = new ArrayList<Review>();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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

    public Restaurant() {
    }

    public Long getId() {
        return id;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getCousine() {
        return cousine;
    }

    public void setCousine(String cousine) {
        this.cousine = cousine;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public int countBookings() {
        return this.bookings.size();
    }

    public int countReviews() {
        return this.reviews.size();
    }

    public int countBookingsParDay(String date) {
        int totBookingParDay = 0;
        for (Booking booking : this.bookings) {
            if (booking.getDate() == date) {
                totBookingParDay += booking.getCovers();
            }

        }
        return totBookingParDay;
    }
}
