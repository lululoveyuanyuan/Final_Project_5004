package model;
/*
CS5004 Final Project: Pet Health Record Application
@Author: Lulu Xu
@Date: 2023/12/10
This is the abstract class that defines the methods of getDate, getDescription, needsFollowUp.
 */

import java.time.LocalDate;

public abstract class HealthEvent {
    private final LocalDate date;
    private final String description;

    public HealthEvent(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }


    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public boolean needsFollowUp() {
        return false;
    }
}

