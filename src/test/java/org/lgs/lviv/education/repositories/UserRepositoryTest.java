package org.lgs.lviv.education.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lgs.lviv.education.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private final String USER_EMAIL =  "email";
    private final String COVER_ID = "cover-id";

    @Before
    public void setup(){
        User user = new User();
        user.setEmail(USER_EMAIL);
        user.setCoverId(COVER_ID);
        userRepository.save(user);
    }

    @Test
    public void itConfirmsEmail() {
        List<User> allUsers = userRepository.findAll();

        assertThat(allUsers).hasSize(1);

        User user = allUsers.get(0);

        assertThat(user.isEmailVerify()).isFalse();

        userRepository.confirmEmail(user.getId());

        List<User> updatedUsers = userRepository.findAll();

        assertThat(updatedUsers).hasSize(1);
        User updatedUser = updatedUsers.get(0);

        assertThat(updatedUser.isEmailVerify()).isTrue();
    }

    @Test
    public void itCanGetUserCoverId() {
        List<User> allUsers = userRepository.findAll();
        assertThat(allUsers).hasSize(1);

        User user = allUsers.get(0);
        String coverId = userRepository.findCoverIdByUserId(user.getId());

        assertThat(coverId).isEqualTo(COVER_ID);
    }
}
