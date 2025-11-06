package tserkovnikov.com.cleanplanetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tserkovnikov.com.cleanplanetapp.model.PartnerServiceHistory;
import java.util.List;

@Repository
public interface ServiceHistoryRepository extends JpaRepository<PartnerServiceHistory, Long> {
    List<PartnerServiceHistory> findByPartnerId(Long partnerId);
}
