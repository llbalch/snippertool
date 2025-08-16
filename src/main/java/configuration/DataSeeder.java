package configuration;
import com.example.snippertool.entity.Snippet;
import com.example.snippertool.entity.User;
import com.example.snippertool.repository.SnippetRepo;
import com.example.snippertool.repository.UserRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner runner(SnippetRepo snippetRepo, UserRepo userRepo) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();

            // Seed Snippets
            InputStream snippetStream = getClass().getResourceAsStream("/data/seedData.json");
            List<Snippet> snippets = mapper.readValue(snippetStream, new TypeReference<List<Snippet>>() {});
            snippetRepo.saveAll(snippets); // batch-insert all snippets

            // Seed Users
            InputStream userStream = getClass().getResourceAsStream("/data/usersSeedData.json");
            List<User> users = mapper.readValue(userStream, new TypeReference<List<User>>() {});
            userRepo.saveAll(users); // batch-insert all users
        };
    }
}