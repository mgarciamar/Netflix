package com.example.netflix.controllers;

import com.example.netflix.repositories.TitleRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TitleController {
    private final TitleRepository repository;
    TitleController(TitleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/best")
    Object best(@RequestParam(defaultValue =  "10") Integer top) {
        return repository.findTopRating(PageRequest.of(0,top));
    }

    @GetMapping("/category/{id}")
    Object top(@RequestParam(defaultValue =  "10") Integer top) {
        return repository.findTopRatingCategory(PageRequest.of(0,top),2);
    }


}
