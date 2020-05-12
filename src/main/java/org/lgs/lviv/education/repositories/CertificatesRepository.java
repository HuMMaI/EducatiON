package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificatesRepository extends JpaRepository<Certificate, Integer> {
    List<Certificate> findByUserId(int userId);

    @Query("SELECT AVG(c.grade) FROM Certificate c WHERE c.user.id = :id")
    Double averageGradeByUserId(@Param("id") int id);
}
