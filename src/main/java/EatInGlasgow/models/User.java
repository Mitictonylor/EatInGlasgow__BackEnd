package EatInGlasgow.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

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
//    private List<Reviews> restaurantReviewed


    public User(String name, String surname, String email, String town, String postcode) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.town = town;
        this.postcode = postcode;
    }

    public User() {
    }
}
