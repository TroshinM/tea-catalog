package com.teacatalog.tea_catalog.controller;

import com.teacatalog.tea_catalog.model.Tea;
import com.teacatalog.tea_catalog.service.TeaService;
import com.teacatalog.tea_catalog.repository.TeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tea")
public class TeaController {
    @Autowired
    private TeaRepository teaRepository;
    @Autowired
    private TeaService teaService;
    @GetMapping
    public List<Tea> getAllTea() {
        return teaRepository.findAll();
    }
    @GetMapping("/search")
    public List<Tea> searchTeas(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return teaService.searchTeas(query, minPrice, maxPrice);
    }
}
