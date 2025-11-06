package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.RatingHistory;

public interface RatingHistoryRepository extends JpaRepository<RatingHistory, Long> {
}
