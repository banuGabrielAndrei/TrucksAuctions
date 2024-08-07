package com.TrucksAuctions.registerLoginUsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.TrucksAuctions.models.UserEntity;
import com.TrucksAuctions.repository.UsersRepository;

@SpringBootTest
@Transactional
public class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @BeforeEach
    void setup() {
        usersRepository.deleteAll();
    }

    @Test
    public void testUserSaving() {
        UserEntity user = new UserEntity();
        user.setName("Andri");
        user.setEmail("andri@gmail.com");
        user.setPassword("abcd");
        user.setRole("ROLE_ADMIN");

        UserEntity savedUser = usersRepository.save(user);

        assertNotNull(savedUser);
        assertNotNull(savedUser.getId());
        assertEquals(savedUser.getName(), "Andri");
        assertEquals(savedUser.getEmail(), "andri@gmail.com");
        assertEquals(savedUser.getPassword(), "abcd");
        assertEquals(savedUser.getRole(), "ROLE_ADMIN");
    }
}
