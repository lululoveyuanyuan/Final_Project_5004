package model;

/*
CS5004 Final Project: Pet Health Record Application
@Author: Lulu Xu
@Date: 2023/12/10
This is the model class that stores the information of the health record.
 */
import java.time.LocalDate;

public class HealthRecord extends HealthEvent {

    // Constructor for model.HealthRecord that takes additional parameters for diagnosis and treatment
    public HealthRecord(LocalDate date, String description) {
        super(date, description);
    }




    @Override
    public String toString() {
        return "Date: " + getDate().toString() +
                ", Description: " + getDescription();
    }

}
