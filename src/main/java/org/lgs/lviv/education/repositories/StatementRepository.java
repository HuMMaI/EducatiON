package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer> {
    @Query("SELECT s FROM Statement s WHERE s.faculty.id = :faculty ORDER BY s.grade DESC")
    List<Statement> findAllByFacultyIdAndOrderByGradeDesc(@Param("faculty") int faculty);
}
