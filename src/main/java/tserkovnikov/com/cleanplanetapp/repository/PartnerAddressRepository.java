package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.PartnerAddress;

public interface PartnerAddressRepository extends JpaRepository<PartnerAddress, Long> {
}
