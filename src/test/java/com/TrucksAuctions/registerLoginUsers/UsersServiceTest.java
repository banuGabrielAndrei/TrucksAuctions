package com.TrucksAuctions.registerLoginUsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.TrucksAuctions.models.UserEntity;
import com.TrucksAuctions.repository.UsersRepository;
import com.TrucksAuctions.services.UsersServiceImpl;



@SpringBootTest
@Transactional
public class UsersServiceTest {

    @InjectMocks
    private UsersServiceImpl usersService;

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser_Success() {
    UserEntity user = new UserEntity();
    when(usersRepository.save(any(UserEntity.class))).thenReturn(user);

    UserEntity savedUser = usersRepository.save(user);
    verify(usersRepository, times(1)).save(user);
    assertNotNull(savedUser);
    assertEquals("user1@gmail.com", savedUser.getEmail());
}

    @Test
    public void testSaveUser_DuplicateEmail() {
        UserEntity user = new UserEntity();
        doThrow(DataIntegrityViolationException.class).
        when(usersRepository).save(any(UserEntity.class));
        assertThrows(DataIntegrityViolationException.class, () -> {
            usersService.saveUser(user);
        });
        verify(usersRepository, times(1)).save(user);
    }
}
