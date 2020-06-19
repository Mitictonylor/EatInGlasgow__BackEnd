package EatInGlasgow.controllers;

import EatInGlasgow.models.Restaurant;
import EatInGlasgow.models.Review;
import EatInGlasgow.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/reviews")
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepo;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReview(){
        return new ResponseEntity<>(reviewRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getReviewById(@PathVariable Long id) {
        return new ResponseEntity<>(reviewRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> postReview(@RequestBody Review review){
        reviewRepo.save(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Review> putRestaurant(@RequestBody Review review){
        reviewRepo.save(review);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

}
