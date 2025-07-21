package com.example.snippertool.controller;
import com.example.snippertool.entity.Snippet;
import com.example.snippertool.payload.SnippetRepo;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/snippets")
public class SnippetController {
    // contains the REST controllers

        private final SnippetRepo repository;

        public SnippetController(SnippetRepo repository) {
            this.repository = repository;
        }
    // POST /snippets
    @PostMapping
    public Snippet createSnippet(@RequestBody Snippet snippet) {
        return repository.save(snippet);
    }

    // GET /snippets?lang=python (bonus)
    @GetMapping
    public List<Snippet> getSnippets(@RequestParam(required = false) String lang) {
        if (lang != null) {
            return repository.findByLanguage(lang);
        }
        return repository.findAll();
    }

    // GET /snippets/{id}
    @GetMapping("/{id}")
    public Snippet getSnippetById(@PathVariable int id) {
        return repository.findById(id);
    }
}

