package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.UserCoverFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCoverFileRepository extends JpaRepository<UserCoverFile, String> {
}
