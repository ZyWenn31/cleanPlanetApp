package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.ServiceEntity;

public interface ServiceEntityRepository extends JpaRepository<ServiceEntity, Long> {
}
