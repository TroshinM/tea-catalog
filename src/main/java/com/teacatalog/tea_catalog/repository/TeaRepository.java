package com.teacatalog.tea_catalog.repository;

import com.teacatalog.tea_catalog.model.Tea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeaRepository extends JpaRepository<Tea, Long> {
    List<Tea> findBySortContainingIgnoreCaseOrKindContainingIgnoreCaseOrAdditivesContainingIgnoreCaseOrManufacturerContainingIgnoreCase(
            String sort, String kind, String additives, String manufacturer);

    List<Tea> findByPriceBetween(Double min, Double max);
}
