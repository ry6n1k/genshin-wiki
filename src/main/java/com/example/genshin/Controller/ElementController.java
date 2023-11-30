package com.example.genshin.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.genshin.Entity.Element;
import com.example.genshin.Service.ElementService;

@RestController
@RequestMapping("/element")
public class ElementController {
    private final ElementService service;

    public ElementController(ElementService service) {
        this.service = service;
    }

    @GetMapping
    public List<Element> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Element> findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    // specify the type of data
    @PostMapping(consumes = { "application/json" })
    public Element save(@RequestBody Element element) {
        return service.save(element);
    }

    @PutMapping
    public Element update(@RequestBody Element element) {
        return service.update(element);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
