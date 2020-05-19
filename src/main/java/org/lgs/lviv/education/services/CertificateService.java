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

    public boolean subjectCheck(String subjectName, int userId) {
        List<String> certificateSubjects = certificatesRepository.findAllCertificateNamesByUserId(userId);

        if (certificateSubjects.isEmpty()){
            return false;
        }

        return certificateSubjects.contains(subjectName);
    }

    public boolean numberOfSubjectsCheck(int userId) {
        long numberOfSubjects = certificatesRepository.findAllCertificateNamesByUserId(userId).stream()
                .count();

        return numberOfSubjects < 6;
    }

    public void deleteById(int id){
        certificatesRepository.deleteById(id);
    }

    public void updateGrade(int grade, int id){
        certificatesRepository.updateGrade(grade, id);
    }

    public int getGradeById(int id){
        return certificatesRepository.getGradeById(id);
    }
}
