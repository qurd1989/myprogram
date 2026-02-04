package org.example;

/*
 * QuizGame.java
 * CS 1102 - Unit 1 Programming Assignment
 *
 * This program simulates a simple quiz game with five multiple-choice questions.
 * It validates user input (A/B/C/D), checks answers, counts correct responses,
 * and prints the final score as a percentage.
 */

import java.util.Scanner;

public class QuizGame {

    // Total number of quiz questions
    private static final int TOTAL_QUESTIONS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;

        System.out.println("==============================");
        System.out.println("      JAVA QUIZ GAME (5Q)     ");
        System.out.println("==============================");
        System.out.println("Enter your answer as A, B, C, or D.\n");

        // Ask five questions
        for (int questionNumber = 1; questionNumber <= TOTAL_QUESTIONS; questionNumber++) {

            // Display the question and options
            printQuestion(questionNumber);

            // Read and validate the user's answer (must be A/B/C/D)
            char userAnswer = readValidAnswer(scanner);

            // Get the correct answer for this question
            char correctAnswer = getCorrectAnswer(questionNumber);

            // Compare answers using if statement
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!\n");
                correctCount++;
            } else {
                System.out.println("Incorrect! The correct answer is " + correctAnswer + ".\n");
            }
        }

        // Compute final score as a percentage
        double percentage = (correctCount / (double) TOTAL_QUESTIONS) * 100.0;

        // Display final results
        System.out.println("==============================");
        System.out.println("Quiz complete!");
        System.out.println("Correct answers: " + correctCount + "/" + TOTAL_QUESTIONS);
        System.out.printf("Final score: %.2f%%%n", percentage);
        System.out.println("==============================");

        scanner.close();
    }

    /*
     * Prints a question and its four options.
     * Uses switch-case to choose the correct question text.
     */
    private static void printQuestion(int questionNumber) {
        switch (questionNumber) {
            case 1:
                System.out.println("Q1) Which data type is used to store whole numbers in Java?");
                System.out.println("  A) double");
                System.out.println("  B) int");
                System.out.println("  C) boolean");
                System.out.println("  D) char");
                break;

            case 2:
                System.out.println("Q2) What keyword is used to create an object in Java?");
                System.out.println("  A) class");
                System.out.println("  B) static");
                System.out.println("  C) new");
                System.out.println("  D) void");
                break;

            case 3:
                System.out.println("Q3) Which loop is best when you know how many times to repeat?");
                System.out.println("  A) for loop");
                System.out.println("  B) while loop");
                System.out.println("  C) do-while loop");
                System.out.println("  D) switch");
                break;

            case 4:
                System.out.println("Q4) Which operator compares two values for equality in Java?");
                System.out.println("  A) =");
                System.out.println("  B) !=");
                System.out.println("  C) <=");
                System.out.println("  D) ==");
                break;

            case 5:
                System.out.println("Q5) Which statement is used to select between many fixed options?");
                System.out.println("  A) switch-case");
                System.out.println("  B) for");
                System.out.println("  C) break");
                System.out.println("  D) return");
                break;

            default:
                // This should never happen because we loop from 1..5
                System.out.println("Invalid question number.");
        }

        System.out.print("Your answer (A/B/C/D): ");
    }

    /*
     * Reads user input and validates it.
     * Keeps asking until the user enters A, B, C, or D.
     */
    private static char readValidAnswer(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();

            // Input validation: must be exactly one character: A/B/C/D
            if (input.length() == 1) {
                char choice = input.charAt(0);
                if (choice == 'A' || choice == 'B' || choice == 'C' || choice == 'D') {
                    return choice;
                }
            }

            System.out.print("Invalid input. Please enter A, B, C, or D: ");
        }
    }

    /*
     * Returns the correct answer for each question.
     * Uses switch-case as required.
     */
    private static char getCorrectAnswer(int questionNumber) {
        switch (questionNumber) {
            case 1: return 'B';
            case 2: return 'C';
            case 3: return 'A';
            case 4: return 'D';
            case 5: return 'A';
            default: return 'A';
        }
    }
}
