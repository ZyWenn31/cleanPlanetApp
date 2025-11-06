package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.WarehouseTransaction;

public interface WarehouseTransactionRepository extends JpaRepository<WarehouseTransaction, Long> {
}
