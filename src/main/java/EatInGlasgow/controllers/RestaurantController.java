package EatInGlasgow.controllers;

import EatInGlasgow.models.Booking;
import EatInGlasgow.models.Restaurant;
import EatInGlasgow.repositories.BookingRepository;
import EatInGlasgow.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping(value = "/restaurants")
    public ResponseEntity<List<Restaurant>> getAllRestaurant() {
        return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/restaurants/{id}")
    public ResponseEntity getRestaurantById(@PathVariable Long id) {
        return new ResponseEntity<>(restaurantRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/restaurants")
    public ResponseEntity<Restaurant> postRestaurant(@RequestBody Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping(value = "/restaurants/{id}")
    public ResponseEntity<Restaurant> putRestaurant(@RequestBody Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @DeleteMapping(value = "/restaurants/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable Long id) {
        restaurantRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Object with id " + id, HttpStatus.OK);
    }

}
