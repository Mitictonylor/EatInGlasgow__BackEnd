package EatInGlasgow.controllers;


import EatInGlasgow.models.Review;
import EatInGlasgow.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewsController {

    @Autowired
    ReviewRepository reviewRepo;

    @GetMapping(value = "/reviews")
    public ResponseEntity<List<Review>> getAllReview(
            @RequestParam(name="restaurant_id", required = false) Long restaurant_id,
          @RequestParam(name="date", required = false) String date,
          @RequestParam(name="user_id", required = false) Long user_id) {
        if (restaurant_id !=null & date !=null){
            return new ResponseEntity<>(reviewRepo.findByRestaurantIdAndDate(user_id, date),HttpStatus.OK);
        }
        if (user_id !=null & date !=null){
            return new ResponseEntity<>(reviewRepo.findByUserIdAndDate(restaurant_id, date),HttpStatus.OK);
        }
        if(restaurant_id !=null){
            return new ResponseEntity<>(reviewRepo.findByRestaurantId(restaurant_id),HttpStatus.OK);
        }
        if(user_id !=null){
            return new ResponseEntity<>(reviewRepo.findByUserId(user_id),HttpStatus.OK);
        }
        return new ResponseEntity<>(reviewRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/reviews/{id}")
    public ResponseEntity getReviewsById(@PathVariable Long id) {
        return new ResponseEntity<>(reviewRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/reviews")
    public ResponseEntity<Review> postReview(@RequestBody Review review) {
        reviewRepo.save(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @PutMapping(value = "/reviews/{id}")
    public ResponseEntity<Review> putReview(@RequestBody Review review) {
        reviewRepo.save(review);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @DeleteMapping(value = "/reviews/{id}")
    public ResponseEntity deleteReview(@PathVariable Long id) {
        reviewRepo.deleteById(id);
        return new ResponseEntity<>("Deleted Object with id " + id, HttpStatus.OK);
    }

}
