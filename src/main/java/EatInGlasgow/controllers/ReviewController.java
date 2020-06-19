package EatInGlasgow.controllers;

import EatInGlasgow.models.Restaurant;
import EatInGlasgow.models.Review;
import EatInGlasgow.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
