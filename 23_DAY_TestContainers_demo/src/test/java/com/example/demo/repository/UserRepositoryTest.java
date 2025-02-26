package com.example.demo.repository;

import com.example.demo.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest  // This ensures a JPA test environment
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;  // This must be properly injected

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("John Doe");

        User savedUser = userRepository.save(user);  // This should now work
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("John Doe");
    }
}
