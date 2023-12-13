package view;
/*
CS5004 Final Project: Pet Health Record Application
@Author: Lulu Xu
@Date: 2023/12/10
this is the view class that displays the information of the pet.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// it is the view class that displays the information of the pet.
public class PetView {
    private final JButton listDescriptionsButton;
    private final JButton displayFollowUpEventsButton;
    private final JButton countEventsButton;

    private final JButton performCheckupButton;
    private final JButton scheduleCheckupButton;
    private final JTextField searchEventTextField;
    private final JButton searchEventButton;
    private final JTextArea petInfoTextArea;
    private final JButton addButton;
    private final JTextField healthEventTextField;
    private final JButton getFollowUpEventsButton;

    // Constructor for view.PetView that takes no parameters
    public PetView() {
        JFrame frame = new JFrame("Pet Health Records");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        petInfoTextArea = new JTextArea(20, 40);
        petInfoTextArea.setEditable(false);
        frame.add(new JScrollPane(petInfoTextArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new FlowLayout());
        healthEventTextField = new JTextField(20);
        inputPanel.add(healthEventTextField);
        JComboBox<String> petTypeComboBox = new JComboBox<>(new String[]{"Dog", "Cat"});
        inputPanel.add(petTypeComboBox);

        addButton = new JButton("Add Health Record");
        inputPanel.add(addButton);
        getFollowUpEventsButton = new JButton("Get Follow-Up Events");
        inputPanel.add(getFollowUpEventsButton);

        performCheckupButton = new JButton("Perform Checkup");
        scheduleCheckupButton = new JButton("Schedule Checkup");
        inputPanel.add(performCheckupButton);
        inputPanel.add(scheduleCheckupButton);
        searchEventTextField = new JTextField(20);
        inputPanel.add(searchEventTextField);
        listDescriptionsButton = new JButton("List Event Descriptions");
        displayFollowUpEventsButton = new JButton("Display Follow-Up Events");
        countEventsButton = new JButton("Count Events"); // Correctly declared and added
        searchEventButton = new JButton("Search Event");
        inputPanel.add(searchEventButton);
        inputPanel.add(listDescriptionsButton);
        inputPanel.add(displayFollowUpEventsButton);
        inputPanel.add(countEventsButton); // Only one addition

        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    // the method of getHealthEventText
    public void setPetInfo(String info) {
        petInfoTextArea.setText(info);
    }

    // the method of getHealthEventText
    public String getHealthEventText() {
        return healthEventTextField.getText();
    }

    // the method of clearHealthEventTextField
    public void clearHealthEventTextField() {
        healthEventTextField.setText("");
    }

    public void addPerformCheckupListener(ActionListener listener) {
        performCheckupButton.addActionListener(listener);
    }
    public void addScheduleCheckupListener(ActionListener listener) {
        scheduleCheckupButton.addActionListener(listener);
    }
    public void addListDescriptionsListener(ActionListener listener) {
        listDescriptionsButton.addActionListener(listener);
    }
    public void addCountEventsListener(ActionListener listener) {
        countEventsButton.addActionListener(listener);
    }

    public void addGetFollowUpEventsListener(ActionListener listener) {
        getFollowUpEventsButton.addActionListener(listener);
    }

    public void addDisplayFollowUpEventsListener(ActionListener listener) {
        displayFollowUpEventsButton.addActionListener(listener);
    }





    public void addHealthRecordListener(ActionListener listenForAddButton) {
        addButton.addActionListener(listenForAddButton);
    }

    public String getSearchEventText() {
        return searchEventTextField.getText();
    }

    public void addSearchEventListener(ActionListener listener) {
        searchEventButton.addActionListener(listener);
    }

}
