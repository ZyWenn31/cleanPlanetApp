package tserkovnikov.com.cleanplanetapp.service;

import org.springframework.stereotype.Service;
import tserkovnikov.com.cleanplanetapp.model.Material;
import tserkovnikov.com.cleanplanetapp.repository.MaterialRepository;

import java.util.List;

@Service
public class MaterialService {
    private final MaterialRepository repository;

    public MaterialService(MaterialRepository repository) {
        this.repository = repository;
    }

    public List<Material> getAll() {
        return repository.findAll();
    }

    public Material getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Material material) {
        repository.save(material);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
