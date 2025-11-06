package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
