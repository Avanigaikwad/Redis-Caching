package com.avani.RedisAndJavaIntegration.service;

import com.avani.RedisAndJavaIntegration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
public class UserService {
    private static final String USER_KEY_PREFIX = "user:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // Simulate a database (in real case, use JPA/Repository)
    private final User databaseUser = new User("1", "John Doe", "john@example.com");

    // Get user by ID (Fetch from Redis or DB)
    public Optional<User> getUserById(String userId) {
        String key = USER_KEY_PREFIX + userId;

        // Check Redis cache
        User cachedUser = (User) redisTemplate.opsForValue().get(key);
        if (cachedUser != null) {
            System.out.println("User found in Redis cache! ✅");
            return Optional.of(cachedUser);
        }

        // If not found, fetch from database (simulated here)
        if ("1".equals(userId)) {
            System.out.println("Fetching user from database... 🗄");
            redisTemplate.opsForValue().set(key, databaseUser, Duration.ofMinutes(5)); // Cache for 5 min
            return Optional.of(databaseUser);
        }
        return Optional.empty();
    }

    }
