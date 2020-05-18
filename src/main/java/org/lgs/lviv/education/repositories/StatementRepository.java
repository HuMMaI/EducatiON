package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Integer> {
    @Query("SELECT s FROM Statement s WHERE s.faculty.id = :facultyId AND s.isCredited = false ORDER BY s.grade DESC")
    List<Statement> findAllByFacultyIdAndIsCreditedAndOrderByGradeDesc(@Param("facultyId") int facultyId);

    @Query(value = "SELECT * FROM statements WHERE faculty_id = :facultyId AND is_credited = false ORDER BY grade DESC LIMIT :limit", nativeQuery = true)
    List<Statement> findAllByFacultyIdAndOrderByGradeDescLimit(@Param("facultyId") int facultyId, @Param("limit") int limit);

    @Modifying
    @Transactional
    @Query("UPDATE Statement s SET s.isCredited = TRUE WHERE s.id IN :ids")
    void setCreditedValue(@Param("ids") Integer[] ids);
}
