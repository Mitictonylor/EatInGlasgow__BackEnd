package EatInGlasgow.controllers;

import EatInGlasgow.models.Review;
import EatInGlasgow.models.User;
import EatInGlasgow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/users")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

}
