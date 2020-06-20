package EatInGlasgow;

import EatInGlasgow.models.Booking;
import EatInGlasgow.models.Restaurant;
import EatInGlasgow.models.Review;
import EatInGlasgow.models.User;
import EatInGlasgow.repositories.BookingRepository;
import EatInGlasgow.repositories.RestaurantRepository;
import EatInGlasgow.repositories.ReviewRepository;
import EatInGlasgow.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	RestaurantRepository restaurantRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	UserRepository userRepository;

	@BeforeEach
	void setUp() {
		User user1 = new User("Timi", "Kiraly", "timi@gmail.com", "Glasgow", "g512ng");
		User user2 = new User ("Antonio", "Lorusso", "antonio@gmail.com", "Glasgow", "g512ng");
		User user3 = new User ("Sarah", "Harrington", "sarah@gmail.com", "Glasgow", "g37tq");
		Restaurant restaurant1 = new Restaurant ("Sapori d’ Italia", "https://files.list.co.uk/images/2016/12/19/img-5552-ti-lst228252_thumb.jpg", 50, "medium", "Italian", 0,  "sappori@gmail.com",  "1021 Cathcart Road", "G42 9XJ", "Glasgow", "16:00", "23:00");
		Restaurant restaurant2 = new Restaurant ("Malaga Tapas", "https://lh5.googleusercontent.com/p/AF1QipMGEUicrNSuM2Myvt59QPLmEbGNU7fEDygL0bvD=w408-h495-k-no", 50, "medium", "Spanish", 0,  "malaga@gmail.com", "213-215 St Andrews Rd", "G41 1PD", "Glasgow", "16:00", "23:00");
		Restaurant restaurant3 = new Restaurant ("Number 16 Restaurant", "https://lh5.googleusercontent.com/p/AF1QipOzTp1NarhEbaD6N5fwcdmDOZzAw1dzqIurhJho=w408-h524-k-no", 40, "expensive", "European", 0, "no16@gmail.com", "16 Byres Rd", "G11 5JY", "Glasgow", "12:00", "23:00");
		Booking booking1 = new Booking ("25/06/20", "17:00", restaurant1, user1, 4);
		Booking booking2 = new Booking ("25/06/20", "17:00", restaurant2, user2, 2);
		Review review1 = new Review ("27/06/20", restaurant1, user1, 5);
		Review review2 = new Review ("27/06/20", restaurant2, user2, 3);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void userCanAddABooking() {
		Restaurant restaurant3 = new Restaurant ("Number 16 Restaurant", "https://lh5.googleusercontent.com/p/AF1QipOzTp1NarhEbaD6N5fwcdmDOZzAw1dzqIurhJho=w408-h524-k-no", 40, "expensive", "European", 0, "no16@gmail.com", "16 Byres Rd", "G11 5JY", "Glasgow", "12:00", "23:00");
		User user3 = new User ("Sarah", "Harrington", "sarah@gmail.com", "Glasgow", "g37tq");
		Booking booking = new Booking ("25/06/20", "17:00", restaurant3, user3, 4);
		user3.addBooking(booking);
		assertEquals(1, user3.countBookings());
	}
	@Test
	void userCanNotAddABooking__restaurantfull() {
		Restaurant restaurant3 = new Restaurant ("Number 16 Restaurant", "https://lh5.googleusercontent.com/p/AF1QipOzTp1NarhEbaD6N5fwcdmDOZzAw1dzqIurhJho=w408-h524-k-no", 2, "expensive", "European", 0, "no16@gmail.com", "16 Byres Rd", "G11 5JY", "Glasgow", "12:00", "23:00");
		User user3 = new User ("Sarah", "Harrington", "sarah@gmail.com", "Glasgow", "g37tq");
		Booking booking = new Booking ("25/06/20", "17:00", restaurant3, user3, 4);
		user3.addBooking(booking);
		assertEquals(0, user3.countBookings());
	}
}
