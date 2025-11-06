package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.CustomerOrder;
import tserkovnikov.com.cleanplanetapp.repository.CustomerOrderRepository;

import java.util.List;

@Service
public class CustomerOrderService {
    private final CustomerOrderRepository repository;

    public CustomerOrderService(CustomerOrderRepository repository) {
        this.repository = repository;
    }

    public List<CustomerOrder> getAll() {
        return repository.findAll();
    }

    public CustomerOrder getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(CustomerOrder o) {
        repository.save(o);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
