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
    public ResponseEntity<List<Review>> getAllReview() {
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
