package org.lgs.lviv.education.entities;

public enum SubjectNames {
    MATHEMATICS("Mathematics"),
    PHYSICS("Physics"),
    HISTORY("History"),
    FOREIGN_LANGUAGE("Foreign language"),
    GEOGRAPHY("Geography"),
    BIOLOGY("Biology");

    String subjectName;

    SubjectNames(String name){
        this.subjectName = name;
    }

    @Override
    public String toString() {
        return subjectName;
    }
}
