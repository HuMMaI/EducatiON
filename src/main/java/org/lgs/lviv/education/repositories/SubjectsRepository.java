package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SubjectsRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findByUserId(int userId);

    @Query("SELECT s.name FROM Subject s WHERE s.user.id = :id")
    List<String> findAllSubjectNamesByUserId(@Param("id") int id);

    @Query("SELECT AVG(s.grade) FROM Subject s WHERE s.user.id = :id")
    double averageGradeByUserId(@Param("id") int id);

    void deleteById(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Subject s SET s.grade = :grade WHERE s.id = :id")
    void updateGrade(@Param("grade") int grade, @Param("id") int id);

    @Query("SELECT s.grade FROM Subject s WHERE s.id = :id")
    int getGradeById(@Param("id") int id);
}
