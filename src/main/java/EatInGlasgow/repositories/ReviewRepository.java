package EatInGlasgow.repositories;

import EatInGlasgow.models.Booking;
import EatInGlasgow.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    public List<Review> findByRestaurantId(Long id);
    public List<Review> findByUserId(Long id);
    public List<Review> findByUserIdAndDate(Long id, String date);
    public List<Review> findByRestaurantIdAndDate(Long id, String date);

}
