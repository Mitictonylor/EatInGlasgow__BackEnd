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
@RequestMapping(name = "/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurant(){
        return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
//        bookingRepository.save(booking);
//        return new ResponseEntity<>(booking, HttpStatus.CREATED);
//    }
//
//    @PutMapping(value="/{id}")
//    public ResponseEntity<Booking> putBooking(@RequestBody Booking booking){
//        bookingRepository.save(booking);
//        return new ResponseEntity<>(booking, HttpStatus.OK);
//    }
//
//    @DeleteMapping(value="/{id}")
//    public ResponseEntity<Long> deleteBooking(@PathVariable Long id){
//        bookingRepository.deleteById(id);
//        return new ResponseEntity<>(id, HttpStatus.OK);
//    }


}
