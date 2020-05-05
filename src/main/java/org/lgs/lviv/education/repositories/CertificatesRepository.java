package org.lgs.lviv.education.repositories;

import org.lgs.lviv.education.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatesRepository extends JpaRepository<Certificate, Integer> {
}
