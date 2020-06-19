package EatInGlasgow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

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

    @Column(name="closing_time")
    private String closingTime;

    @JsonBackReference
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Booking> customerBooked;

      @JsonBackReference
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Review> customerReviews;


    public Restaurant(String name, int capacity, String priceRange, String cousine, int discount, String email, String address, String postcode, String town, String openingTime, String closingTime) {
        this.name = name;
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
        this.customerBooked = new ArrayList<Booking>();
        this.customerReviews = new ArrayList<Review>();

    }

    public Restaurant() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public String getCousine() {
        return cousine;
    }

    public int getDiscount() {
        return discount;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getTown() {
        return town;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public void setCousine(String cousine) {
        this.cousine = cousine;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }
}
