package tserkovnikov.com.cleanplanetapp.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.PartnerServiceHistory;
import tserkovnikov.com.cleanplanetapp.repository.ServiceHistoryRepository;

import java.util.List;

@Service
public  class ServiceHistoryService {
    private final ServiceHistoryRepository repository;

    public ServiceHistoryService(ServiceHistoryRepository repository) {
        this.repository = repository;
    }

    public List<PartnerServiceHistory> getAll() {
        return repository.findAll();
    }

    public List<PartnerServiceHistory> getByPartner(Long partnerId) {
        return repository.findByPartnerId(partnerId);
    }

    public PartnerServiceHistory save(PartnerServiceHistory history) {
        return repository.save(history);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
