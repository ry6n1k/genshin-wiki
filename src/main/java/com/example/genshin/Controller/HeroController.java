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

import com.example.genshin.Entity.Hero;
import com.example.genshin.Service.HeroService;

@RestController
@RequestMapping("/hero")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public List<Hero> findAll() {
        return heroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Hero> findById(@PathVariable("id") Integer id) {
        return heroService.findById(id);
    }

    // specify the type of data
    @PostMapping(consumes = { "application/json" })
    public Hero saveHero(@RequestBody Hero hero) {
        return heroService.save(hero);
    }

    @PutMapping
    public Hero update(@RequestBody Hero hero) {
        return heroService.update(hero);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        heroService.delete(id);
    }
}