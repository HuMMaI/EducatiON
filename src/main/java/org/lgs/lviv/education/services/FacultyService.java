package org.lgs.lviv.education.services;

import org.lgs.lviv.education.entities.Faculty;
import org.lgs.lviv.education.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> findAll(){
        return facultyRepository.findAll();
    }

    public void save(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public void create(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public void delete(int id){
        facultyRepository.deleteById(id);
    }
}
