package model;
/*
CS5004 Final Project: Pet Health Record Application
@Author: Lulu Xu
@Date: 2023/12/10
This is the abstract class that defines the methods of getDate, getDescription, needsFollowUp.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class Pet {
    private final String name;
    final int age;
    final String breed;
    private final List<HealthEvent> healthRecord = new LinkedList<>();

    // Constructor for model.Pet that takes additional parameters for age and breed
    public Pet(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }
    // Constructor for model.Pet that takes only the name
    public void addHealthRecord(HealthEvent event) {
        healthRecord.add(event);
    }


    // Additional getters and setters
    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public String getBreed() {
        return breed;
    }

    // this method is used to get the health record of the pet
    public List<HealthEvent> getHealthRecord() {
        return healthRecord;
    }

    public HealthEvent findEventByDescription(List<HealthEvent> events, String description) {
        if (events.isEmpty()) {
            return null;
        }
        HealthEvent head = events.get(0);
        if (head.getDescription().equals(description)) {
            return head;
        }
        // Call the method recursively on the tail of the list
        return findEventByDescription(events.subList(1, events.size()), description);
    }

    // Higher-order function - map
    public List<String> mapEvents(Function<HealthEvent, String> mapper) {
        List<String> mappedEvents = new ArrayList<>();
        for (HealthEvent event : this.healthRecord) {
            mappedEvents.add(mapper.apply(event));
        }
        return mappedEvents;
    }
    // Higher-order function - filter
    public List<HealthEvent> filterEvents(Predicate<HealthEvent> predicate) {
        List<HealthEvent> filteredEvents = new ArrayList<>();
        for (HealthEvent event : this.healthRecord) {
            if (predicate.test(event)) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }

    // Higher-order function - fold
    public <T> T foldEvents(T identity, BinaryOperator<T> accumulator, Function<HealthEvent, T> transformer) {
        T result = identity;
        for (HealthEvent event : this.healthRecord) {
            result = accumulator.apply(result, transformer.apply(event));
        }
        return result;
    }
}


