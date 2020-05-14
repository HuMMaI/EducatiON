package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.entities.RequestStatus;
import org.lgs.lviv.education.entities.Statement;
import org.lgs.lviv.education.repositories.CertificatesRepository;
import org.lgs.lviv.education.repositories.RequestsRepository;
import org.lgs.lviv.education.repositories.StatementRepository;
import org.lgs.lviv.education.repositories.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementService {
    private final StatementRepository statementRepository;
    private final SubjectsRepository subjectsRepository;
    private final CertificatesRepository certificatesRepository;
    private final RequestsRepository requestsRepository;

    @Autowired
    public StatementService(StatementRepository statementRepository, SubjectsRepository subjectsRepository, CertificatesRepository certificatesRepository, RequestsRepository requestsRepository) {
        this.statementRepository = statementRepository;
        this.subjectsRepository = subjectsRepository;
        this.certificatesRepository = certificatesRepository;
        this.requestsRepository = requestsRepository;
    }

    public void save(Request request){
        Statement statement = new Statement();

        statement.setUser(request.getUser());
        statement.setFaculty(request.getFaculty());

        double averageSubjectGrade = round(subjectsRepository.averageGradeByUserId(request.getUser().getId()), 2);
        double averageCertificateGrade = round(certificatesRepository.averageGradeByUserId(request.getUser().getId()), 2);
        double grade = round(averageSubjectGrade + averageCertificateGrade, 2);

        statement.setAverageGradeOfSubjects(averageSubjectGrade);
        statement.setAverageGradeOfCertificate(averageCertificateGrade);
        statement.setGrade(grade);

        requestsRepository.setStatusById(request.getId(), RequestStatus.ACCEPTED.toString());

        statementRepository.save(statement);
    }

    public List<Statement> getRatingList(int facultyId){
        return statementRepository.findAllByFacultyIdAndOrderByGradeDesc(facultyId);
    }

    private double round(Double value, int n){
        double newValue = value * Math.pow(10, n);
        int intValue = (int)Math.round(newValue);

        return (double)intValue / Math.pow(10, n);
    }
}
