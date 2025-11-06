package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.ServiceMaterial;
import tserkovnikov.com.cleanplanetapp.repository.ServiceMaterialRepository;

import java.util.List;

@Service
public class ServiceMaterialService {
    private final ServiceMaterialRepository repository;

    public ServiceMaterialService(ServiceMaterialRepository repository) {
        this.repository = repository;
    }

    public List<ServiceMaterial> getAll() {
        return repository.findAll();
    }

    public ServiceMaterial getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(ServiceMaterial sm) {
        repository.save(sm);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
