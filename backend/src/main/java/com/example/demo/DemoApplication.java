package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    
    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

@RestController
@RequestMapping("/api")
class UserController {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @GetMapping("/users")
    public List<User> getUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
    
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        entityManager.persist(user);
        return user;
    }
    
    @GetMapping("/health")
    public String health() {
        return "Backend is healthy!";
    }
}