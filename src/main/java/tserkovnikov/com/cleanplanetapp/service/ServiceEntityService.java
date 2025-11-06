package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.ServiceEntity;
import tserkovnikov.com.cleanplanetapp.repository.ServiceEntityRepository;

import java.util.List;

@Service
public class ServiceEntityService {
    private final ServiceEntityRepository repository;

    public ServiceEntityService(ServiceEntityRepository repository) {
        this.repository = repository;
    }

    public List<ServiceEntity> getAll() {
        return repository.findAll();
    }

    public ServiceEntity getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(ServiceEntity s) {
        repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
