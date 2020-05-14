package org.lgs.lviv.education.entities;

public enum FacultySpecialization {
    IT("IT"),
    MATH("Math"),
    PHYSICS("Physics"),
    LANGUAGE("Language"),
    LAW("Law"),
    HISTORY("History");

    String specializationName;

    FacultySpecialization(String name){
        this.specializationName = name;
    }

    @Override
    public String toString() {
        return specializationName;
    }
}
