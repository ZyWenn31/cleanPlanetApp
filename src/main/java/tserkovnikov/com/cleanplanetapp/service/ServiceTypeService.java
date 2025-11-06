package tserkovnikov.com.cleanplanetapp.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.ServiceType;
import tserkovnikov.com.cleanplanetapp.repository.ServiceTypeRepository;

import java.util.List;

@Service
public class ServiceTypeService {
    private final ServiceTypeRepository repository;

    public ServiceTypeService(ServiceTypeRepository repository) {
        this.repository = repository;
    }

    public List<ServiceType> getAll() {
        return repository.findAll();
    }

    public ServiceType getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ServiceType save(ServiceType type) {
        return repository.save(type);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
