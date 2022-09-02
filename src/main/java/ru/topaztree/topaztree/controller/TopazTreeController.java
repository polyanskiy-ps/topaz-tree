package ru.topaztree.topaztree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.topaztree.topaztree.dto.TopazTreeDto;
import ru.topaztree.topaztree.entity.TopazTreeEntity;
import ru.topaztree.topaztree.service.TopazTreeService;

@RestController
@Component
public class TopazTreeController {

    @Autowired
    private TopazTreeService topazTreeService;

    @PostMapping("/topaz_tree")
    public int saveTree(@RequestBody TopazTreeDto topazTreeDto) {
        TopazTreeEntity topazTreeEntity = topazTreeService.saveInDataBase(topazTreeDto);
        return topazTreeService.calculateWeight(topazTreeDto);
    }

    @GetMapping("/")
    public TopazTreeDto getWeight() {
        return topazTreeService.getWeight();
    }
}
