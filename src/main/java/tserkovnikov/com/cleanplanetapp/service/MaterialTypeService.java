package tserkovnikov.com.cleanplanetapp.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.MaterialType;
import tserkovnikov.com.cleanplanetapp.repository.MaterialTypeRepository;

import java.util.List;

@Service
public class MaterialTypeService {
    private final MaterialTypeRepository repository;

    public MaterialTypeService(MaterialTypeRepository repository) {
        this.repository = repository;
    }

    public List<MaterialType> getAll() {
        return repository.findAll();
    }

    public MaterialType getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MaterialType save(MaterialType materialType) {
        return repository.save(materialType);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
