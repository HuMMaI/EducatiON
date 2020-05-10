package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.Certificate;
import org.lgs.lviv.education.repositories.CertificatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {
    private final CertificatesRepository certificatesRepository;

    @Autowired
    public CertificateService(CertificatesRepository certificatesRepository) {
        this.certificatesRepository = certificatesRepository;
    }


    public List<Certificate> findAll() {
        return certificatesRepository.findAll();
    }

    public void save(Certificate certificate) {
        certificatesRepository.save(certificate);
    }

    public List<Certificate> findByUserId(int userId) {
        return certificatesRepository.findByUserId(userId);
    }
}
