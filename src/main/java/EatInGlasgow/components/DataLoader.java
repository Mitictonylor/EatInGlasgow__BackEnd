package EatInGlasgow.components;

import EatInGlasgow.models.Review;
import EatInGlasgow.models.User;
import EatInGlasgow.repositories.BookingRepository;
import EatInGlasgow.repositories.RestaurantRepository;
import EatInGlasgow.repositories.ReviewRepository;
import EatInGlasgow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("Timi", "Kiraly", "timi@gmail.com", "Glasgow", "g512ng");
        User user2 = new User ("Antonio", "Lorusso", "antonio@gmail.com", "Glasgow", "g512ng");
        User user3 = new User ("Sarah", "Harrington", "sarah@gmail.com", "Glasgow", "g37tq");
        User user4 = new User ("John", "Smith", "john@gmail.com", "Glasgow", "g311jd");
        User user5 = new User ("Paul", "Robertson", "paul@gmail.com", "Paisley", "pa12de");
        User user6 = new User ("Rachel", "Dawson", "rachel@gmail.com", "Glasgow", "g641ut");
        User user7 = new User ("Eloise", "Summers", "eloise@gmail.com", "Glasgow", "g318se");
        User user8 = new User ("Harry", "Brown", "harry@gmail.com", "Motherwell", "ml13dg");
        User user9 = new User ("Michael", "Anderson", "michael@gmail.com", "Glasgow", "g414pg");
        User user10 = new User ("Anna", "Darcy", "anna@gmail.com", "Glasgow", "g514tf");
        User user11 = new User ("Robert", "Simmons", "robert@gmail.com", "Glasgow", "g128qq");
        User user12 = new User ("Lisa", "Wilson", "lisa@gmail.com", "Glasgow", "g38ag");
        User user13 = new User ("Peter", "McDonald", "peter@gmail.com", "Glasgow", "g50an");
        User user14 = new User ("Silvia", "Dickens", "silvia@gmail.com", "Glasgow", "g731ug");
        User user15 = new User ("George", "Reynolds", "george@gmail.com", "Glasgow", "g58dj");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user9);
        userRepository.save(user10);
        userRepository.save(user11);
        userRepository.save(user12);
        userRepository.save(user13);
        userRepository.save(user14);
        userRepository.save(user15);

        



    }
}
