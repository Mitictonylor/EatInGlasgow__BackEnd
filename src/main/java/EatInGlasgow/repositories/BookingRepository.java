package EatInGlasgow.repositories;

import EatInGlasgow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    public List<Booking> findByRestaurantId(Long id);
    public List<Booking> findByUserId(Long id);
    public List<Booking> findByUserIdAndDate(Long id, String date);
    public List<Booking> findByRestaurantIdAndDate(Long id, String date);
}
