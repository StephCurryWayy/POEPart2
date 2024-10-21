/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart2final;
import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */

public class Task {
    private static int taskCount = 0;
    private int taskNumber;
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int duration;
    private String taskStatus;

    public Task(int number) {
        this.taskNumber = number;
        setTaskName();
        setTaskDescription();
        setDeveloperDetails();
        setDuration();
        setTaskStatus();
    }

    private void setTaskName() {
        this.taskName = JOptionPane.showInputDialog("Enter Task Name:");
    }

    private void setTaskDescription() {
        String description;
        while (true) {
            description = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
            if (checkTaskDescription(description)) {
                this.taskDescription = description;
                JOptionPane.showMessageDialog(null, "Task successfully captured");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            }
        }
    }

    private boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    private void setDeveloperDetails() {
        this.developerDetails = JOptionPane.showInputDialog("Enter Developer Details (First Last):");
    }

    private void setDuration() {
        this.duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (hours):"));
    }

    private void setTaskStatus() {
        String[] options = {"To Do", "Doing", "Done"};
        int choice = JOptionPane.showOptionDialog(null, "Select Task Status:", "Task Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        this.taskStatus = options[choice];
    }

    public String createTaskID() {
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" +
                developerDetails.split(" ")[1].substring(developerDetails.split(" ")[1].length() - 3).toUpperCase();
        return taskID;
    }

    public int getDuration() {
        return duration;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
                "\nDeveloper Details: " + developerDetails +
                "\nTask Number: " + taskNumber +
                "\nTask Name: " + taskName +
                "\nTask Description: " + taskDescription +
                "\nTask ID: " + createTaskID() +
                "\nDuration: " + duration + " hours";
    }
}