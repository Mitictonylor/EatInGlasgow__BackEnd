package EatInGlasgow.controllers;

import EatInGlasgow.models.Booking;
import EatInGlasgow.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
        @RequestParam(name="restaurant_id", required = false) Long restaurant_id,
        @RequestParam(name="date", required = false) String date,
        @RequestParam(name="user_id", required = false) Long user_id) {
        if (restaurant_id !=null & date !=null){
            return new ResponseEntity<>(bookingRepository.findByRestaurantIdAndDate(user_id, date),HttpStatus.OK);
        }
        if (user_id !=null & date !=null){
            return new ResponseEntity<>(bookingRepository.findByUserIdAndDate(restaurant_id, date),HttpStatus.OK);
        }
        if(restaurant_id !=null){
            return new ResponseEntity<>(bookingRepository.findByRestaurantId(restaurant_id),HttpStatus.OK);
        }
        if(user_id !=null){
            return new ResponseEntity<>(bookingRepository.findByUserId(user_id),HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity getBookingById(@PathVariable Long id) {
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> putBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity deleteBooking(@PathVariable Long id) {
        bookingRepository.deleteById(id);
        return new ResponseEntity<>("Deleted Object with id " + id, HttpStatus.OK);
    }


}
