package EatInGlasgow.repositories;

import EatInGlasgow.models.Booking;
import EatInGlasgow.models.Restaurant;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {


}
