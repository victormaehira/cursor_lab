package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) { this.userRepository = userRepository; }
    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserRequest request) {
        User user = new User(request.getName());
        User saved = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    public record UserRequest(String name) {}
}
