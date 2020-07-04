package EatInGlasgow.controllers;

import EatInGlasgow.models.User;
import EatInGlasgow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userRepo.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        userRepo.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


    @PatchMapping(value = "/customers/{id}")
    public ResponseEntity<User> putUser( @RequestBody User user) {
        userRepo.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return new ResponseEntity<>("Deleted Object with id " + id, HttpStatus.OK);
    }
}
