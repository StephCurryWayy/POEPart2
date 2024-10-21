/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart2final;
import javax.swing.*;
import java.util.ArrayList;


/**
 *
 * @author RC_Student_lab
 */

public class POEPart2Final {
    private String firstName;
    private String lastName;
    private String username = "user";  // Mock username
    private String password = "password";  // Mock password
    private ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        POEPart2Final app = new POEPart2Final();
        if (app.login()) {
            app.startTaskManagement();
        }
    }

    public boolean login() {
        String inputUsername = JOptionPane.showInputDialog("Enter your username:");
        String inputPassword = JOptionPane.showInputDialog("Enter your password:");

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            firstName = "Robyn";
            lastName = "Harrison";
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
            return false;
        }
    }

    public void startTaskManagement() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to enter?"));

        for (int i = 0; i < numTasks; i++) {
            Task task = new Task(i);
            tasks.add(task);
            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }

        int totalHours = tasks.stream().mapToInt(Task::getDuration).sum();
        JOptionPane.showMessageDialog(null, "Total Hours: " + totalHours);
    }
}