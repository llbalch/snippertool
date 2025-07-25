package com.example.snippertool.controller;

import Utility.Crypto;
import com.example.snippertool.entity.Snippet;
import com.example.snippertool.payload.SnippetRepo;
import java.util.Optional;

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
            snippet.setCode(Crypto.encrypt(snippet.getCode()));
        return repository.save(snippet);
    }

//     GET /snippets?lang=python (bonus)
    @GetMapping()
    public List<Snippet> getSnippets(@RequestParam(required = false) String lang) {
        List<Snippet> snippets = (lang != null) ?
                repository.findByLanguage(lang) : repository.findAll();
      for (Snippet s : snippets) {
          s.setCode(Crypto.decrypt(s.getCode()));
      }
      return snippets;
    }

    // GET /snippets/{id}
    @GetMapping("/{id}")
    public Snippet getSnippetById(@PathVariable int id) {
       Optional<Snippet> snippetOpt = Optional.ofNullable(repository.findById(id));
               Snippet snippet = snippetOpt.orElseThrow(() -> new RuntimeException("Snippet not found"));
       snippet.setCode(Crypto.decrypt(snippet.getCode()));
        return snippet;
    }
}

