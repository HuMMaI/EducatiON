package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CertificatesRepository extends JpaRepository<Certificate, Integer> {
    List<Certificate> findByUserId(int userId);

    @Query("SELECT AVG(c.grade) FROM Certificate c WHERE c.user.id = :id")
    double averageGradeByUserId(@Param("id") int id);

    @Query("SELECT c.name FROM Certificate c WHERE c.user.id = :id")
    List<String> findAllCertificateNamesByUserId(@Param("id") int id);

    void deleteById(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Certificate c SET c.grade = :grade WHERE c.id = :id")
    void updateGrade(@Param("grade") int grade, @Param("id") int id);

    @Query("SELECT c.grade FROM Certificate c WHERE c.id = :id")
    int getGradeById(@Param("id") int id);
}
