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

import java.util.List;

import static org.junit.Assert.*;

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



	@Test
	void contextLoads() {
	}

	@Test
	void userCanAddABooking() {
		Restaurant restaurant3 = new Restaurant ("Number 16 Restaurant", "https://lh5.googleusercontent.com/p/AF1QipOzTp1NarhEbaD6N5fwcdmDOZzAw1dzqIurhJho=w408-h524-k-no", 40, "expensive", "European", 0, "no16@gmail.com", "16 Byres Rd", "G11 5JY", "Glasgow", "12:00", "23:00");
		User user3 = new User ("Sarah", "Harrington", "sarah@gmail.com", "Glasgow", "g37tq");
		Booking booking = new Booking ("25/06/20", "17:00", restaurant3, user3, 4);
		assertEquals(0, user3.countBookings());
		assertEquals(0, restaurant3.countBookings());
		user3.addBooking(booking);
		assertEquals(1, user3.countBookings());
		assertEquals(1, restaurant3.countBookings());
		assertEquals(user3, restaurant3.getBookings().get(0).getUser());
	}
	@Test
	void userCanNotAddABooking__restaurantFull() {
		Restaurant restaurant3 = new Restaurant ("Number 16 Restaurant", "https://lh5.googleusercontent.com/p/AF1QipOzTp1NarhEbaD6N5fwcdmDOZzAw1dzqIurhJho=w408-h524-k-no", 2, "expensive", "European", 0, "no16@gmail.com", "16 Byres Rd", "G11 5JY", "Glasgow", "12:00", "23:00");
		User user3 = new User ("Sarah", "Harrington", "sarah@gmail.com", "Glasgow", "g37tq");
		Booking booking = new Booking ("25/06/20", "17:00", restaurant3, user3, 4);
		user3.addBooking(booking);
		assertEquals(0, user3.countBookings());
	}

	@Test
	void userCanNotAddABooking__restaurantNotOpen__tooEarly() {
		Restaurant restaurant3 = new Restaurant ("Number 16 Restaurant", "https://lh5.googleusercontent.com/p/AF1QipOzTp1NarhEbaD6N5fwcdmDOZzAw1dzqIurhJho=w408-h524-k-no", 60, "expensive", "European", 0, "no16@gmail.com", "16 Byres Rd", "G11 5JY", "Glasgow", "17:00", "23:00");
		User user3 = new User ("Sarah", "Harrington", "sarah@gmail.com", "Glasgow", "g37tq");
		Booking booking = new Booking ("25/06/20", "16:00", restaurant3, user3, 4);
		user3.addBooking(booking);
		assertEquals(0, user3.countBookings());
	}

	@Test
	void userCanNotAddABooking__restaurantNotOpen__tooLate() {
		Restaurant restaurant3 = new Restaurant ("Number 16 Restaurant", "https://lh5.googleusercontent.com/p/AF1QipOzTp1NarhEbaD6N5fwcdmDOZzAw1dzqIurhJho=w408-h524-k-no", 60, "expensive", "European", 0, "no16@gmail.com", "16 Byres Rd", "G11 5JY", "Glasgow", "17:00", "18:59");
		User user3 = new User ("Sarah", "Harrington", "sarah@gmail.com", "Glasgow", "g37tq");
		Booking booking = new Booking ("25/06/20", "19:00", restaurant3, user3, 4);
		user3.addBooking(booking);
		assertEquals(0, user3.countBookings());
	}

	@Test
	void userCanNotAddAReview__neverBeenToTheRestaurant() {
		Restaurant restaurant3 = new Restaurant ("Number 16 Restaurant", "https://lh5.googleusercontent.com/p/AF1QipOzTp1NarhEbaD6N5fwcdmDOZzAw1dzqIurhJho=w408-h524-k-no", 2, "expensive", "European", 0, "no16@gmail.com", "16 Byres Rd", "G11 5JY", "Glasgow", "12:00", "23:00");
		User user3 = new User ("Sarah", "Harrington", "sarah@gmail.com", "Glasgow", "g37tq");
		Review review2 = new Review ("27/06/20", restaurant3, user3, 3);
		user3.addReviews(review2);
		assertEquals(0, user3.countReviews());
		assertEquals(0, restaurant3.getBookings().size());
	}
	@Test
	void userCanAddAReview() {
		Restaurant restaurant3 = new Restaurant ("Number 16 Restaurant", "https://lh5.googleusercontent.com/p/AF1QipOzTp1NarhEbaD6N5fwcdmDOZzAw1dzqIurhJho=w408-h524-k-no", 50, "expensive", "European", 0, "no16@gmail.com", "16 Byres Rd", "G11 5JY", "Glasgow", "12:00", "23:00");
		User user3 = new User ("Sarah", "Harrington", "sarah@gmail.com", "Glasgow", "g37tq");
		Booking booking = new Booking ("25/06/20", "19:00", restaurant3, user3, 4);
		Review review2 = new Review ("27/06/20", restaurant3, user3, 3);
		user3.addBooking(booking);
		assertEquals(user3, restaurant3.getBookings().get(0).getUser());
		user3.addReviews(review2);
		assertEquals(1, user3.countReviews());
		assertEquals(user3, restaurant3.getBookings().get(0).getUser());
		assertEquals(user3, restaurant3.getReviews().get(0).getUser());
	}

	@Test
	void findBookingsByRestaurantId() {
		List<Booking> foundBookings = bookingRepository.findByRestaurantId(1L);
		assertEquals(2, foundBookings.size());
	}

	@Test
	void findBookingsByUserId() {
		List<Booking> foundBookings = bookingRepository.findByUserId(2L);
		assertEquals(2, foundBookings.size());
	}

	@Test
	void findBookingsByUserIdAndDate() {
			List<Booking> foundBookings = bookingRepository.findByUserIdAndDate(2L, "25/06/20");
			assertEquals(1, foundBookings.size());
		}


	@Test
	void findBookingsByRestaurantIdAndDate() {
		List<Booking> foundBookings = bookingRepository.findByRestaurantIdAndDate(1L, "25/06/20");
		assertEquals(1, foundBookings.size());
	}

	@Test
	void findReviewsByRestaurantId() {

	}

	@Test
	void findReviewsByUserId() {
	}

	@Test
	void findReviewsByUserIdAndDate() {
	}

	@Test
	void findReviewsByRestaurantIdAndDate() {

	}



}
