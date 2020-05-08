package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsRepository extends JpaRepository<Request, Integer> {
}
