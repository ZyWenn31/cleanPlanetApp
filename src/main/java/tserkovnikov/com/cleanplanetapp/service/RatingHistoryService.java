package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.RatingHistory;
import tserkovnikov.com.cleanplanetapp.repository.RatingHistoryRepository;

import java.util.List;

@Service
public class RatingHistoryService {
    private final RatingHistoryRepository repository;

    public RatingHistoryService(RatingHistoryRepository repository) {
        this.repository = repository;
    }

    public List<RatingHistory> getAll() {
        return repository.findAll();
    }

    public RatingHistory getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(RatingHistory r) {
        repository.save(r);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
