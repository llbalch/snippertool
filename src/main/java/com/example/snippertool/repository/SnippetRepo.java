package com.example.snippertool.repository;
import com.example.snippertool.entity.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SnippetRepo extends JpaRepository<Snippet, Integer> {
    List<Snippet> findByLanguage(String lang);
}
