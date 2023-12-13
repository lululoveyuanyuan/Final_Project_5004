package controller;
/*
CS5004 Final Project: Pet Health Record Application
@Author: Lulu Xu
@Date: 2023/12/10
It is the controller class that controls the view and model.
 */
import model.*;
import view.PetView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

// the controller class
public class PetController {
    private Pet model;
    private final PetView view;
// the constructor of PetController
    public PetController(PetView view) {
        this.view = view;
        this.view.addHealthRecordListener(new AddHealthRecordListener());
        // Add listeners for the buttons
        view.addPerformCheckupListener(e -> performPetCheckup());
        view.addScheduleCheckupListener(e -> schedulePetCheckup());
        view.addSearchEventListener(e -> handleSearchEvent());
        view.addListDescriptionsListener(e -> listEventDescriptions());
        view.addDisplayFollowUpEventsListener(e -> displayFollowUpEvents());
        view.addCountEventsListener(e -> countHealthEvents());
        view.addGetFollowUpEventsListener(e -> getEventsNeedingFollowUp());
    }

    // the method of performPetCheckup
    public void performPetCheckup() {
        if (model != null && model instanceof HealthCheckable) {
            ((HealthCheckable) model).performCheckup();
            // Update the view with a message about the checkup
            view.setPetInfo("Performing dog-specific checkup for " + model.getName() + "\n");
        }
    }
    // the method of schedulePetCheckup
    public void schedulePetCheckup() {
        if (model != null && model instanceof HealthCheckable) {
            ((HealthCheckable) model).scheduleCheckup();
            view.setPetInfo("Next checkup for " + model.getName() + " has been scheduled\n");
        }
    }


    // the method of getEventsNeedingFollowUp
    public void getEventsNeedingFollowUp() {
        List<HealthEvent> followUpEvents = model.filterEvents(HealthEvent::needsFollowUp);
        StringBuilder sb = new StringBuilder("Follow-up needed for these events:\n");
        for (HealthEvent event : followUpEvents) {
            sb.append(event.toString()).append("\n");
        }
        view.setPetInfo(sb.toString());
    }

    // the method of listEventDescriptions
    public void listEventDescriptions() {
        List<String> descriptions = model.mapEvents(HealthEvent::getDescription);
        view.setPetInfo(String.join("\n", descriptions));
    }

    // the method of displayFollowUpEvents
    public void displayFollowUpEvents() {
        List<HealthEvent> followUpEvents = model.filterEvents(HealthEvent::needsFollowUp);
        StringBuilder sb = new StringBuilder();
        for (HealthEvent event : followUpEvents) {
            sb.append(event.toString()).append("\n");
        }
        view.setPetInfo(sb.toString());
    }




    // the method of countHealthEvents
    public void countHealthEvents() {
        int count = model.foldEvents(0, (accumulator, event) -> accumulator + 1, event -> 1);
        view.setPetInfo("Total number of health events: " + count);
    }

    // the method of updateView
    public void updateView() {
        if (model != null) {
            StringBuilder info = new StringBuilder();
            info.append(model.getName()).append("\n")
                    .append(model.getAge()).append("\n")
                    .append(model.getBreed()).append("\n\nHealth Records:\n");

            for (HealthEvent event : model.getHealthRecord()) {
                info.append(event.toString()).append("\n");
            }

            view.setPetInfo(info.toString());
        }
    }

    // the method of createPetBasedOnUserInput
    public void createPetBasedOnUserInput(String name, int age, String breed, String petType) {
        if ("Dog".equals(petType)) {
            model = new Dog(name, age, breed);
        } else if ("Cat".equals(petType)) {
            model = new Cat(name, age, breed);
        }
        updateView();
    }
    // the method of handleSearchEvent
    public void handleSearchEvent() {
        String description = view.getSearchEventText();
        HealthEvent foundEvent = model.findEventByDescription(model.getHealthRecord(), description);
        if (foundEvent != null) {
            view.setPetInfo(foundEvent.toString());
        } else {
            view.setPetInfo("Event not found");
        }
    }

    // the method of AddHealthRecordListener
    class AddHealthRecordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String description = view.getHealthEventText();
            if (!description.isEmpty()) {
                HealthEvent healthEvent = new HealthRecord(LocalDate.now(), description);
                model.addHealthRecord(healthEvent);
                view.clearHealthEventTextField();
                updateView();
            }
        }
    }

}
