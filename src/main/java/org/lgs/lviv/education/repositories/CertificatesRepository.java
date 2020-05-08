package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificatesRepository extends JpaRepository<Certificate, Integer> {
    List<Certificate> findByUserId(int userId);
}
