package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.DoorAccess;
import tserkovnikov.com.cleanplanetapp.repository.DoorAccessRepository;

import java.util.List;

@Service
public class DoorAccessService {
    private final DoorAccessRepository repository;

    public DoorAccessService(DoorAccessRepository repository) {
        this.repository = repository;
    }

    public List<DoorAccess> getAll() {
        return repository.findAll();
    }

    public DoorAccess getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(DoorAccess a) {
        repository.save(a);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
