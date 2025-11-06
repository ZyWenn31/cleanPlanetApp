package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.ServiceMaterial;

import java.util.List;

public interface ServiceMaterialRepository extends JpaRepository<ServiceMaterial, Long> {
    List<ServiceMaterial> findByServiceId(Long serviceId);
}
