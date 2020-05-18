package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByVerifyHashCode(String hash);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.isEmailVerify=TRUE WHERE u.id=:userId")
    void confirmEmail(@Param("userId") int id);

    @Query("SELECT u.coverId FROM User u WHERE u.id = :id")
    String findCoverIdByUserId(@Param("id") int id);
}
