package com.starter.spring_bootstrap.domain.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldPersistUser() {
        User user = User.builder()
                .username("test-user")
                .build();

        User savedUser = userRepository.saveAndFlush(user);

        assertNotNull(savedUser.getId());
        assertNotNull(savedUser.getCreatedAt());
        assertNotNull(savedUser.getUpdatedAt());
        assertEquals("test-user", savedUser.getUsername());
    }

    @Test
    void shouldNotPersistUserWithDuplicateUsername() {
        User firstUser = User.builder()
                .username("test-user")
                .build();

        User secondUser = User.builder()
                .username("test-user")
                .build();

        userRepository.saveAndFlush(firstUser);

        assertThrows(DataIntegrityViolationException.class, () ->
                userRepository.saveAndFlush(secondUser)
        );
    }
}