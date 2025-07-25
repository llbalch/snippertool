package com.example.snippertool.payload;
import com.example.snippertool.entity.User;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
    private final Map<Integer, User> users = new HashMap<>();
    private int currentId = 1;

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User findById(int id) {
        return users.get(id);
    }

    public Optional<User> findByEmail(String email) {
        for (User u : users.values()) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    public User save (User user) {
        user.setId(currentId++);
        users.put(user.getId(), user);
        return user;
    }
}


