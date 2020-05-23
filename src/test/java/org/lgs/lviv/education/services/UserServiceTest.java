package org.lgs.lviv.education.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lgs.lviv.education.entities.Roles;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.repositories.UserCoverFileRepository;
import org.lgs.lviv.education.repositories.UserRepository;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private static final int USER_ID = 20;
    public static final String USER_EMAIL = "test@gmail.com";
    public static final String USER_PASSWORD = "123";
    private static final String USER_PASSWORD_ENCODED = "pass-encoded";
    public static final String FIRST_NAME = "FirstTest";
    public static final String LAST_NAME = "LstTest";
    private static final String CONFIRM_HASH = "gdsa34-ht56h4-bwq54f";

    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private MailSenderService mailSenderService;
    @Mock
    private UserCoverFileRepository userCoverFileRepository;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    private UserService userService;

    @Before
    public void setup(){
        userService = new UserService(userRepository, passwordEncoder, userCoverFileRepository, mailSenderService);
    }

    @Test
    public void itCanConfirmEmail(){
        User user = new User();
        user.setId(USER_ID);

        when(userRepository.findByVerifyHashCode(CONFIRM_HASH))
                .thenReturn(Optional.of(user));

        userService.confirmEmail(CONFIRM_HASH);

        verify(userRepository).findByVerifyHashCode(CONFIRM_HASH);
        verify(userRepository).confirmEmail(USER_ID);
    }

    @Test
    public void itCanConfirmEmailWhenUserNotFound() {
        when(userRepository.findByVerifyHashCode(CONFIRM_HASH))
                .thenReturn(Optional.empty());

        userService.confirmEmail(CONFIRM_HASH);

        verify(userRepository).findByVerifyHashCode(CONFIRM_HASH);
        verify(userRepository, times(0)).confirmEmail(anyInt());
    }

    @Test
    public void itCanRegisterUser() {
        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setPassword(USER_PASSWORD);

        when(passwordEncoder.encode(USER_PASSWORD))
                .thenReturn(USER_PASSWORD_ENCODED);

        userService.create(user);

        User expectedUser = new User(FIRST_NAME, LAST_NAME, USER_EMAIL);
        expectedUser.setRoles(Collections.singleton(Roles.ENROLLEE));
        expectedUser.setEmailVerify(false);
        expectedUser.setPassword(USER_PASSWORD_ENCODED);
        expectedUser.setVerifyHashCode("hash");

        verify(userRepository).save(userCaptor.capture());

        assertThat(userCaptor.getValue())
                .isEqualToIgnoringGivenFields(expectedUser, "verifyHashCode");

        verify(mailSenderService).send(eq(USER_EMAIL), anyString(), anyString());
    }
}
