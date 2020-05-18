package org.lgs.lviv.education.entities;

public enum RequestStatus {
    CANCELED("Canceled"),
    WAITING("Waiting"),
    ACCEPTED("Accepted"),
    CREDITED("Credited"),
    NOT_CREDITED("Not credited");

    String statusName;

    RequestStatus(String name){
        this.statusName = name;
    }

    @Override
    public String toString() {
        return statusName;
    }
}
