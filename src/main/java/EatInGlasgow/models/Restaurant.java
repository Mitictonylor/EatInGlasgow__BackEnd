package EatInGlasgow.models;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

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

//    @JsonBackReference
//    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
//    private List<Booking> customerBooked

    //  @JsonBackReference
//    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
//    private List<Reviews> CustomerReviews


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

    }

    public Restaurant() {
    }
}
