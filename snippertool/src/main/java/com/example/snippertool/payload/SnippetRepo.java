package com.example.snippertool.payload;
import com.example.snippertool.entity.Snippet;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class SnippetRepo {
    private final Map<Integer, Snippet> snippets = new HashMap<>();
    private int currentId = 1;

    public List<Snippet> findAll() {
        return new ArrayList<>(snippets.values());
    }

    public Snippet findById(int id) {
        return snippets.get(id);
    }

    public List<Snippet> findByLanguage(String lang) {
        List<Snippet> result = new ArrayList<>();
        for (Snippet s : snippets.values()) {
            if (s.getLanguage().equalsIgnoreCase(lang)) result.add(s);
        }
        return result;
    }

    public Snippet save(Snippet snippet) {
        snippet.setId(currentId++);
        snippets.put(snippet.getId(), snippet);
        return snippet;
    }
}
