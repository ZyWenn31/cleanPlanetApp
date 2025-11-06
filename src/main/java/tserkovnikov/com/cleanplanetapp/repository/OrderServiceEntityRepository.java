package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.OrderServiceEntity;

public interface OrderServiceEntityRepository extends JpaRepository<OrderServiceEntity, Long> {
}
