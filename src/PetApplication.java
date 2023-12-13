import view.PetView;
import controller.PetController;

/*
CS5004 Final Project: Pet Health Record Application
@Author: Lulu Xu
@Date: 2023/12/10
This is the main class that runs the application.
 */
public class PetApplication {
    public static void main(String[] args) {
        PetView view = new PetView();
        PetController controller = new PetController(view);

       // this is the user input
        String petType = "Dog"; // or "Cat"
        String name = "Buddy";
        int age = 5;
        String breed = "Labrador";



        controller.createPetBasedOnUserInput(name, age, breed, petType);
    }
}
