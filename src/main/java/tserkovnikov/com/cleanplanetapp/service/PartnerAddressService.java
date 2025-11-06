package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.PartnerAddress;
import tserkovnikov.com.cleanplanetapp.repository.PartnerAddressRepository;

import java.util.List;

@Service
public class PartnerAddressService {
    private final PartnerAddressRepository repository;

    public PartnerAddressService(PartnerAddressRepository repository) {
        this.repository = repository;
    }

    public List<PartnerAddress> getAll() {
        return repository.findAll();
    }

    public PartnerAddress getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(PartnerAddress address) {
        repository.save(address);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
