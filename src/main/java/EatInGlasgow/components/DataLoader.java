package EatInGlasgow.components;

import EatInGlasgow.models.Review;
import EatInGlasgow.repositories.BookingRepository;
import EatInGlasgow.repositories.RestaurantRepository;
import EatInGlasgow.repositories.ReviewRepository;
import EatInGlasgow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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

    }
}
