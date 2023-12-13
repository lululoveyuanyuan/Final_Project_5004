package model;
/*
CS5004 Final Project: Pet Health Record Application
@Author: Lulu Xu
@Date: 2023/12/10
this is the model class that stores the information of the pet: dog.
 */

public class Dog extends Pet implements HealthCheckable {

    public Dog(String name, int age, String breed) {
        super(name, age, breed);
    }



    @Override
    public void performCheckup() {
        System.out.println("Performing dog-specific checkup for " + getName());
        // Additional checkup routines specific to dogs
    }
    @Override
    public void scheduleCheckup() {
        System.out.println("Next checkup for " + getName() + " (Dog) has been scheduled.");
        // Specific scheduling logic for dogs
    }

}

