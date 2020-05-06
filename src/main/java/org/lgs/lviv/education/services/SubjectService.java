package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.Subject;
import org.lgs.lviv.education.repositories.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectsRepository subjectsRepository;

    @Autowired
    public SubjectService(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }


    public List<Subject> findAll() {
        return subjectsRepository.findAll();
    }

    public void save(Subject subject) {
        subjectsRepository.save(subject);
    }
}