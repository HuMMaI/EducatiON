package org.lgs.lviv.education.entities;

public enum FacultySubjects {
    MATHEMATICS("Mathematics"),
    PHYSICS("Physics"),
    HISTORY("History"),
    FOREIGN_LANGUAGE("Foreign language");

    String subjectName;

    FacultySubjects(String name){
        this.subjectName = name;
    }

    @Override
    public String toString() {
        return subjectName;
    }
}
