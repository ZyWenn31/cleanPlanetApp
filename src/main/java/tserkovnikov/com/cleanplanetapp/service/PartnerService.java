package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.Partner;
import tserkovnikov.com.cleanplanetapp.repository.PartnerRepository;

import java.util.List;

@Service
public class PartnerService {
    private final PartnerRepository repository;

    public PartnerService(PartnerRepository repository) {
        this.repository = repository;
    }

    public List<Partner> getAll() {
        return repository.findAll();
    }

    public Partner getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Partner save(Partner partner) {
        return repository.save(partner);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
