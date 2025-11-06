package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.Supplier;
import tserkovnikov.com.cleanplanetapp.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService {
    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public List<Supplier> getAll() {
        return repository.findAll();
    }

    public Supplier getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Supplier supplier) {
        repository.save(supplier);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
