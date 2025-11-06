package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.OrderServiceEntity;
import tserkovnikov.com.cleanplanetapp.repository.OrderServiceEntityRepository;

import java.util.List;

@Service
public class OrderServiceEntityService {
    private final OrderServiceEntityRepository repository;

    public OrderServiceEntityService(OrderServiceEntityRepository repository) {
        this.repository = repository;
    }

    public List<OrderServiceEntity> getAll() {
        return repository.findAll();
    }

    public OrderServiceEntity getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(OrderServiceEntity s) {
        repository.save(s);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
