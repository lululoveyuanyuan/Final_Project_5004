import controller.PetController;
import view.PetView;
/*
CS5004 Final Project: Pet Health Record Application
@Author: Lulu Xu
@Date: 2023/12/10
This is the test class that tests the controller.
 */


public class TestPetController {
    public static void main(String[] args) {
        PetView view = new PetView();
        PetController controller = new PetController(view);
        controller.updateView();
    }
}
