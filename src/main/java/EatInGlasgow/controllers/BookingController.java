package EatInGlasgow.controllers;

import EatInGlasgow.models.Booking;
import EatInGlasgow.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity getBookingById(@PathVariable Long id) {
        return new ResponseEntity<>(bookingRepository.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Booking> putBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }




}
