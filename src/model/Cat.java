package model;
/*
CS5004 Final Project: Pet Health Record Application
@Author: Lulu Xu
@Date: 2023/12/10
This is the model class that stores the information of the pet: cat.
 */

public class Cat extends Pet implements HealthCheckable {

    public Cat(String name, int age, String breed) {
        super(name, age, breed);
    }




    @Override
    public void performCheckup() {
        System.out.println("Performing cat-specific checkup for " + getName());
        // Additional checkup routines specific to cats
    }


    @Override
    public void scheduleCheckup() {
        System.out.println("Next checkup for " + getName() + " (Cat) has been scheduled.");
        // Specific scheduling logic for cats
    }

}
