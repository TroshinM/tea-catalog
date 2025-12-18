package com.teacatalog.tea_catalog.service;
import com.teacatalog.tea_catalog.model.Tea;
import com.teacatalog.tea_catalog.repository.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaService {
    @Autowired
    private TeaRepository repo;

    public List<Tea> getAllTeas() {
        return repo.findAll();
    }

    public List<Tea> searchTeas(String query, Double minPrice, Double maxPrice) {
        List<Tea> result;
        if (query == null || query.trim().isEmpty()) {
            result = repo.findAll();
        } else {
            result = repo.findBySortContainingIgnoreCaseOrKindContainingIgnoreCaseOrAdditivesContainingIgnoreCaseOrManufacturerContainingIgnoreCase(
                    query, query, query, query);
        }
        if (minPrice != null || maxPrice != null) {
            Double finalMinPrice = minPrice != null ? minPrice : 0.0;
            Double finalMaxPrice = maxPrice != null ? maxPrice : Double.MAX_VALUE;
            result.removeIf(t -> t.getPrice() < finalMinPrice || t.getPrice() > finalMaxPrice);
        }
        return result;
    }
}
