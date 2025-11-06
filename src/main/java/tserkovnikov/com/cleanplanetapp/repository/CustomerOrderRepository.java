package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
