package com.example.snippertool.controller;
import com.example.snippertool.entity.Snippet;
import com.example.snippertool.entity.User;
import com.example.snippertool.repository.SnippetRepo;
import com.example.snippertool.repository.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snippets")
public class SnippetController {
  // contains the REST controllers

        private final SnippetRepo snippetRepo;
        private final UserRepo userRepo;

    public SnippetController(SnippetRepo snippetRepo, UserRepo userRepo) {
            this.userRepo = userRepo;
            this.snippetRepo = snippetRepo;
    }
    // POST /snippets/users/{userId}
    @PostMapping("users/{userId}/snippets")
    public Snippet createSnippetForUser(@PathVariable Integer userId, @RequestBody Snippet snippet) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        snippet.setUser(user);
        return snippetRepo.save(snippet);
    }

//     GET /snippets?lang=python (bonus)
    @GetMapping()
    public List<Snippet> getSnippets(@RequestParam(required = false) String lang) {
        return (lang != null) ? snippetRepo.findByLanguage(lang) : snippetRepo.findAll();
    }

    // GET /snippets/{id}
    @GetMapping("/{id}")
    public Snippet getSnippetById(@PathVariable int id) {
        return snippetRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Snippet not found"));
    }
}

