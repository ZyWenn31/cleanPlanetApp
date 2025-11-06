package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
