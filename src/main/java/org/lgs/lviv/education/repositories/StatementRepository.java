package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer> {
}
