package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findByUserId(int userId);

    @Query("SELECT s.name FROM Subject s WHERE s.user.id = :id")
    List<String> findAllSubjectNamesByUserId(@Param("id") int id);
}
