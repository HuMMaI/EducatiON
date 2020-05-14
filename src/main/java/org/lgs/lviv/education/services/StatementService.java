package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.Request;
import org.lgs.lviv.education.entities.RequestStatus;
import org.lgs.lviv.education.entities.Statement;
import org.lgs.lviv.education.entities.User;
import org.lgs.lviv.education.repositories.CertificatesRepository;
import org.lgs.lviv.education.repositories.RequestsRepository;
import org.lgs.lviv.education.repositories.StatementRepository;
import org.lgs.lviv.education.repositories.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatementService {
    private final StatementRepository statementRepository;
    private final SubjectsRepository subjectsRepository;
    private final CertificatesRepository certificatesRepository;
    private final RequestsRepository requestsRepository;
    private final MailSenderService mailSenderService;

    @Value("${appBaseDomain}")
    private String appBaseDomain;

    @Autowired
    public StatementService(StatementRepository statementRepository, SubjectsRepository subjectsRepository, CertificatesRepository certificatesRepository, RequestsRepository requestsRepository, MailSenderService mailSenderService) {
        this.statementRepository = statementRepository;
        this.subjectsRepository = subjectsRepository;
        this.certificatesRepository = certificatesRepository;
        this.requestsRepository = requestsRepository;
        this.mailSenderService = mailSenderService;
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

    public void saveCanceledRequest(Request request) {
        request.setStatus(RequestStatus.CANCELED.toString());
        request.getUser().setApply(false);

        requestsRepository.save(request);
    }

    public void statementResult(int facultyId, int limit, String facultyName){
        List<Statement> statementList = statementRepository.findAllByFacultyIdAndOrderByGradeDescLimit(facultyId, limit);

        Integer[] ids = statementList.stream()
                .map(Statement::getId)
                .toArray(Integer[]::new);

        statementRepository.setCreditedValue(ids);

        Integer[] userIds = statementList.stream()
                .map(s -> s.getUser().getId())
                .toArray(Integer[]::new);

        requestsRepository.setStatusByIds(userIds, RequestStatus.CREDITED.toString(), facultyId);

        List<User> users = statementList.stream()
                .map(Statement::getUser)
                .collect(Collectors.toList());

        for (User user : users) {
            String message = String.format(
                    "Hi, %s\n" +
                            "The results of admission to %s faculty became known.\n" +
                            "Go to find out %s/cabinet.",
                    user.getFirstName(), facultyName, appBaseDomain
            );
            mailSenderService.send(user.getEmail(), "Request result", message);
        }
    }

    private double round(Double value, int n){
        double newValue = value * Math.pow(10, n);
        int intValue = (int)Math.round(newValue);

        return (double)intValue / Math.pow(10, n);
    }
}
