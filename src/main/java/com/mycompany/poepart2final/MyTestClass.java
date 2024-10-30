/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart2final;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author RC_Student_lab
 */
public class MyTestClass {

    // Main test class for unit tests
    public static class TaskTest {

        @Test
        void testCheckTaskDescriptionSuccess() {
            Task task = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
            assertTrue(task.checkTaskDescription(), "Task successfully captured");
        }

        @Test
        void testCheckTaskDescriptionFailure() {
            Task task = new Task("Login Feature", "This description is way too long and exceeds the limit of fifty characters.", "Robyn Harrison", 8, "To Do");
            assertFalse(task.checkTaskDescription(), "Please enter a task description of less than 50 characters.");
        }

        @Test
        void testCreateTaskID() {
            Task task = new Task("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
            assertEquals("LO:0:SON", task.createTaskID(), "TaskID is correct");
        }

        @Test
        void testReturnTotalHours() {
            EasyKanban app = new EasyKanban();
            // Use a method to add test tasks in EasyKanban class
            app.addTestTask(new Task("Task 1", "Short desc", "Developer One", 10, "To Do"));
            app.addTestTask(new Task("Task 2", "Another short desc", "Developer Two", 5, "Doing"));
            assertEquals(15, app.returnTotalHours(), "Total hours should be correct");
        }
    }
}
