package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tserkovnikov.com.cleanplanetapp.model.MaterialType;

@Repository
public interface MaterialTypeRepository extends JpaRepository<MaterialType, Long> {
}

