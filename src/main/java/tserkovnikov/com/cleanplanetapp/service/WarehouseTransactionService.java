package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.WarehouseTransaction;
import tserkovnikov.com.cleanplanetapp.repository.WarehouseTransactionRepository;

import java.util.List;

@Service
public class WarehouseTransactionService {
    private final WarehouseTransactionRepository repository;

    public WarehouseTransactionService(WarehouseTransactionRepository repository) {
        this.repository = repository;
    }

    public List<WarehouseTransaction> getAll() {
        return repository.findAll();
    }

    public WarehouseTransaction getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(WarehouseTransaction t) {
        repository.save(t);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
