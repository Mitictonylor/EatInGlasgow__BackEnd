package EatInGlasgow.controllers;

import EatInGlasgow.models.User;
import EatInGlasgow.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {


    private final Logger log = LoggerFactory.getLogger(UsersController.class);
    private UserRepository userRepo;

    public UsersController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        userRepo.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


    @PatchMapping(value = "/users/{id}")
    public ResponseEntity<User> putUser( @RequestBody User user) {
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return new ResponseEntity<>("Deleted Object with id " + id, HttpStatus.OK);
    }
}
