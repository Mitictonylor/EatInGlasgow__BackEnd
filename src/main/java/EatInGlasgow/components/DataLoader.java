package EatInGlasgow.components;

import EatInGlasgow.models.Booking;
import EatInGlasgow.models.Restaurant;
import EatInGlasgow.models.Review;
import EatInGlasgow.models.User;
import EatInGlasgow.repositories.BookingRepository;
import EatInGlasgow.repositories.RestaurantRepository;
import EatInGlasgow.repositories.ReviewRepository;
import EatInGlasgow.repositories.UsersRepository;
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
    UsersRepository usersRepository;

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

        usersRepository.save(user1);
        usersRepository.save(user2);
        usersRepository.save(user3);
        usersRepository.save(user4);
        usersRepository.save(user5);
        usersRepository.save(user6);
        usersRepository.save(user7);
        usersRepository.save(user8);
        usersRepository.save(user9);
        usersRepository.save(user10);
        usersRepository.save(user11);
        usersRepository.save(user12);
        usersRepository.save(user13);
        usersRepository.save(user14);
        usersRepository.save(user15);


        Restaurant restaurant1 = new Restaurant ("Sapori d’ Italia", "https://files.list.co.uk/images/2016/12/19/img-5552-ti-lst228252_thumb.jpg", 50, "medium", "Italian", 0,  "sappori@gmail.com",  "1021 Cathcart Road", "G42 9XJ", "Glasgow", "16:00", "23:00");

        Restaurant restaurant2 = new Restaurant ("Malaga Tapas", "https://lh5.googleusercontent.com/p/AF1QipMGEUicrNSuM2Myvt59QPLmEbGNU7fEDygL0bvD=w408-h495-k-no", 50, "medium", "Spanish", 0,  "malaga@gmail.com", "213-215 St Andrews Rd", "G41 1PD", "Glasgow", "16:00", "23:00");

        Restaurant restaurant3 = new Restaurant ("Number 16 Restaurant", "https://lh5.googleusercontent.com/p/AF1QipOzTp1NarhEbaD6N5fwcdmDOZzAw1dzqIurhJho=w408-h524-k-no", 40, "expensive", "European", 0, "no16@gmail.com", "16 Byres Rd", "G11 5JY", "Glasgow", "12:00", "23:00");

        Restaurant restaurant4 = new Restaurant ("Cail Bruich", "https://lh5.googleusercontent.com/p/AF1QipM4ki-omm6UYLniacSfi6COzGXsN9SEsqBypngD=w408-h285-k-no", 45, "expensive", "French", 0,  "cb@gmail.com", "725 Great Western Rd", "G12 8QX", "Glasgow", "12:00", "23:00");

        Restaurant restaurant5 = new Restaurant ("The Red Onion",  "https://lh5.googleusercontent.com/p/AF1QipMgj4klZXwrgTt0OArkQGMS4PcO_72L0m9u8UAa=w408-h240-k-no-pi0-ya240-ro0-fo100", 60, "cheap", "European", 0, "redo@gmail.com", "257 W Campbell St", "G2 4TT", "Glasgow", "12:00", "23:00");

        Restaurant restaurant6 = new Restaurant ("Black Sheep Bistro", "https://lh5.googleusercontent.com/p/AF1QipMyLHrPpHCb5RwVcobHkPHfq1NpwIgaXzAfT-uT=w408-h306-k-no", 80, "cheap", "British", 0, "blacksheepb@gmail.com", "10 Clarendon St", "G20 7QD", "Glasgow", "12:00", "22:00");

        Restaurant restaurant7 = new Restaurant ("Paesano", "https://lh5.googleusercontent.com/p/AF1QipMdz4uViRzrikvXv88NLGA4_g7M1lw_R-dRcXyj=w480-h240-k-no", 120,  "medium", "Italian", 0, "paesano@gmail.com", "94 Miller St", "G1 1DT", "Glasgow", "12:00", "21:00");

        Restaurant restaurant8 = new Restaurant ("Miller & Carter", "https://lh5.googleusercontent.com/p/AF1QipMwhalZegA4l_jibCbOr9OBSEHX5gi7yOD_rIei=w408-h272-k-no", 60,  "expensive", "steak house", 0, "m&c@gmail.com", "3 fairburn St", "G327qa", "Glasgow", "12:00", "23:00");

        Restaurant restaurant9 = new Restaurant ("Wagamama", "https://lh5.googleusercontent.com/p/AF1QipMakr-NLCSBVzn5fYBF8UgE-DKOip1Pv6ELKq1U=w408-h306-k-no", 80, "medium", "Japanese" , 0, "wagam@gmail.com", "97 W George St", "G2 1PB", "Glasgow", "12:00", "21:00");

        Restaurant restaurant10 = new Restaurant ("India Quay", "https://lh5.googleusercontent.com/p/AF1QipOpZtlWMVko-XFC4ahgXgShcoM2YHoMhDVUnpqX=w426-h240-k-no", 80, "medium", "Indian", 10,"iq@gmail.com", "181 Finnieston St", "G3 8HE", "Glasgow", "16:00", "23:00");

        Restaurant restaurant11 = new Restaurant ("TGI Fridays", "https://lh5.googleusercontent.com/p/AF1QipPtLpO6-lOdfb49dENpEtwqSwjBeuWP341qHYsf=w408-h544-k-no", 100,  "medium", "American", 0,  "tgif@gmail.com", "50 Provan Walk St Ann Way", "G34 9DL", "Glasgow", "12:00", "23:00");

        Restaurant restaurant12 = new Restaurant ("Two Fat Ladies at the Buttery", "https://lh5.googleusercontent.com/p/AF1QipNLlnPRcVL-8Q_5PAuwAlT_uKaSa8P2NvIlA07a=w466-h240-k-no", 60,  "medium", "Scottish", 0, "tflatb@gmail.com", "652 Argyle St", "G3 8UF", "Glasgow", "17:00", "23:00");

        Restaurant restaurant13 = new Restaurant ("Lotus Vegetarian Cuisine", "https://lh5.googleusercontent.com/p/AF1QipPuexoV4sz4Y0aaFjejf0S2GYm1KVsyAn1N6kFM=w408-h306-k-no", 50, "cheap", "vegan", 0, "lotus@gmail.com", "69 Bridge St", "G5 9JB", "Glasgow", "12:00", "20:00");

        Restaurant restaurant14 = new Restaurant ("The Gardener", "https://lh5.googleusercontent.com/p/AF1QipPnA2IqW8G8ES5CcJqKVETzsniCJ4nFc9Lv892r=w408-h272-k-no", 50, "medium", "cocktail bar", 0,  "gardener@gmail.com", "24 Ashton Ln", "G12 8SJ", "Glasgow", "11:00", "22:00");

        Restaurant restaurant15 = new Restaurant ("Bread Meats Bread", "https://lh5.googleusercontent.com/p/AF1QipNgPp7KAhNnHTIw27evM4O2-DwyGlbLoyiOwQw=w408-h272-k-no", 80,  "medium", "American", 0,  "bmb@gmail.com", "701 Great Western Rd", "G12 8RA", "Glasgow", "12:00", "22:00");
        Restaurant restaurant16 = new Restaurant ("Loks Bar and Kitchen", "https://lh5.googleusercontent.com/p/AF1QipPq33b2D8_KnQmvUT_C4BFK7uepzbN6DLVZWuI3=w426-h240-k-no", 70, "medium", "Steakhouse", 10,  "loks@gmail.com", "16 Newlandsfield Rd", "G43 2XU", "Glasgow", "10:00", "23:00");

        Restaurant restaurant17 = new Restaurant ("Ox and Finch", "https://lh5.googleusercontent.com/p/AF1QipNpCS7raIb-F039ml89a8cHBPu2qWEJi-EryBUC=w543-h240-k-no", 50, "medium", "Spanish", 0, "oxandfinch@gmail.com", "920 Sauchiehall St", "G3 7TF", "Glasgow", "12:00", "22:00");

        Restaurant restaurant18 = new Restaurant ("Loop & Scoop", "https://lh5.googleusercontent.com/p/AF1QipN0wDl-oCLjAtC1d0uazjJMnZq6btwZK0ks670-=w408-h306-k-no", 60,  "medium", "English", 0, "lands@gmail.com", "665 Great Western Rd", "G12 8RE", "Glasgow", "12:00", "22:00");

        Restaurant restaurant19 = new Restaurant ("Crabshakk", "https://lh5.googleusercontent.com/p/AF1QipNfOwvmm_XrGxA_6ZBQXi9C9Q0lurwZA4h8CtoC=w408-h306-k-no", 50,  "medium", "Scottish", 0, "crabshakk@gmail.com", "1114 Argyle St", "G3 8TD", "Glasgow", "12:00", "22:00");

        Restaurant restaurant20 = new Restaurant ("Baffo", "https://lh5.googleusercontent.com/p/AF1QipPKOYa26JYWeG8w1AZOYRrGF5ZId99ejvVtBXaH=w408-h272-k-no", 45,  "medium", "Italian", 0,  "baffo@gmail.com", "1377 Argyle St", "G3 8AF", "Glasgow", "11:00", "22:00");

        restaurantRepository.save(restaurant1);
        restaurantRepository.save(restaurant2);
        restaurantRepository.save(restaurant3);
        restaurantRepository.save(restaurant4);
        restaurantRepository.save(restaurant5);
        restaurantRepository.save(restaurant6);
        restaurantRepository.save(restaurant7);
        restaurantRepository.save(restaurant8);
        restaurantRepository.save(restaurant9);
        restaurantRepository.save(restaurant10);
        restaurantRepository.save(restaurant11);
        restaurantRepository.save(restaurant12);
        restaurantRepository.save(restaurant13);
        restaurantRepository.save(restaurant14);
        restaurantRepository.save(restaurant15);
        restaurantRepository.save(restaurant16);
        restaurantRepository.save(restaurant17);
        restaurantRepository.save(restaurant18);
        restaurantRepository.save(restaurant19);
        restaurantRepository.save(restaurant20);

        Booking booking1 = new Booking ("2020-06-25", "17:00", restaurant1, user1, 4);
        Booking booking2 = new Booking ("2020-06-25", "17:00", restaurant2, user2, 2);
        Booking booking3 = new Booking ("2020-06-25", "17:00", restaurant3, user3, 7);
        Booking booking4 = new Booking ("2020-06-25", "17:00", restaurant4, user4, 4);
        Booking booking5 = new Booking ("2020-06-25", "17:00", restaurant5, user5, 4);
        Booking booking6 = new Booking ("2020-06-25", "17:00", restaurant6, user6, 4);
        Booking booking7 = new Booking ("2020-06-25", "17:00", restaurant7, user7, 4);
        Booking booking8 = new Booking ("2020-06-25", "17:00", restaurant8, user8, 2);
        Booking booking9 = new Booking ("2020-06-25", "17:00", restaurant9, user9, 3);
        Booking booking10 = new Booking ("2020-06-25", "17:00", restaurant10, user10, 4);
        Booking booking11 = new Booking ("2020-06-25", "17:00", restaurant11, user11, 4);
        Booking booking12 = new Booking ("2020-06-25", "17:00", restaurant12, user12, 4);
        Booking booking13 = new Booking ("2020-06-25", "17:00", restaurant13, user13, 4);
        Booking booking14 = new Booking ("2020-06-25", "17:00", restaurant14, user14, 5);
        Booking booking15 = new Booking ("2020-06-25", "17:00", restaurant15, user15, 4);
        Booking booking16 = new Booking ("2020-06-30", "17:00", restaurant16, user1, 1);
        Booking booking17 = new Booking ("2020-06-31", "17:00", restaurant17, user1, 4);
        Booking booking18 = new Booking ("2020-07-06", "17:00", restaurant18, user1, 5);
        Booking booking19 = new Booking ("2020-07-10", "17:00", restaurant19, user1, 3);
        Booking booking20 = new Booking ("2020-07-14", "17:00", restaurant20, user1, 6);
        Booking booking21 = new Booking ("2020-07-10", "17:00", restaurant1, user2, 2);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
        bookingRepository.save(booking6);
        bookingRepository.save(booking7);
        bookingRepository.save(booking8);
        bookingRepository.save(booking9);
        bookingRepository.save(booking10);
        bookingRepository.save(booking11);
        bookingRepository.save(booking12);
        bookingRepository.save(booking13);
        bookingRepository.save(booking14);
        bookingRepository.save(booking15);
        bookingRepository.save(booking16);
        bookingRepository.save(booking17);
        bookingRepository.save(booking18);
        bookingRepository.save(booking19);
        bookingRepository.save(booking20);
        bookingRepository.save(booking21);


        Review review1 = new Review ("2020-06-27", restaurant1, user1, 5);
        Review review2 = new Review ("2020-06-27", restaurant2, user2, 3);
        Review review3 = new Review ("2020-06-27", restaurant3, user3, 4);
        Review review4 = new Review ("2020-06-27", restaurant4, user4, 4);
        Review review5 = new Review ("2020-06-27", restaurant5, user5, 4);
        Review review6 = new Review ("2020-06-27", restaurant6, user6, 5);
        Review review7 = new Review ("2020-06-27", restaurant7, user7, 5);
        Review review8 = new Review ("2020-06-27", restaurant8, user8, 4);
        Review review9 = new Review ("2020-06-27", restaurant9, user9, 2);
        Review review10 = new Review ("2020-06-27", restaurant10, user10, 5);
        Review review11 = new Review ("2020-06-27", restaurant11, user11, 5);
        Review review12 = new Review ("2020-06-27", restaurant12, user12, 1);
        Review review13 = new Review ("2020-06-27", restaurant13, user13, 4);
        Review review14 = new Review ("2020-06-27", restaurant14, user14, 4);
        Review review15 = new Review ("2020-06-27", restaurant15, user15, 5);
        Review review16 = new Review ("2020-07-15", restaurant16, user1, 2);
        Review review17 = new Review ("2020-07-15", restaurant17, user1, 4);
        Review review18 = new Review ("2020-07-15", restaurant18, user1, 3);
        Review review19 = new Review ("2020-07-15", restaurant19, user1, 4);
        Review review20 = new Review ("2020-07-15", restaurant20, user1, 4);
        Review review21 = new Review ("2020-07-15", restaurant1, user2, 5);

        reviewRepository.save(review1);
        reviewRepository.save(review2);
        reviewRepository.save(review3);
        reviewRepository.save(review4);
        reviewRepository.save(review5);
        reviewRepository.save(review6);
        reviewRepository.save(review7);
        reviewRepository.save(review8);
        reviewRepository.save(review9);
        reviewRepository.save(review10);
        reviewRepository.save(review11);
        reviewRepository.save(review12);
        reviewRepository.save(review13);
        reviewRepository.save(review14);
        reviewRepository.save(review15);
        reviewRepository.save(review16);
        reviewRepository.save(review17);
        reviewRepository.save(review18);
        reviewRepository.save(review19);
        reviewRepository.save(review20);
        reviewRepository.save(review21);

    }
}
