package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tserkovnikov.com.cleanplanetapp.model.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
