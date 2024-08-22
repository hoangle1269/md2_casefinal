package Controller;

import Model.Students;

import java.util.Scanner;

public class MainMenu implements Constants {
    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        Students students = new Students();

        while (true) {
            System.out.println("Main Menu");
            System.out.println(MAIN_MENU_STUDENT + ". Student");
            System.out.println(MAIN_MENU_LIBRARIAN + ". Librarian");
            System.out.println(MAIN_MENU_EXIT + ". Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case MAIN_MENU_STUDENT:
                        System.out.print("Enter ID: ");
                        String id = scanner.next();
                        System.out.print("Enter Name: ");
                        String name = scanner.next();
                        System.out.print("Enter Course: ");
                        String course = scanner.next();
                        students.addStudent(new Model.Student(id, name, course));
                        StudentMenu.display();
                        break;
                    case MAIN_MENU_LIBRARIAN:
                        System.out.print("Enter Password: ");
                        String password = scanner.next();
                        if (password.matches("CodeGym")) {
                            LibrarianMenu.display();
                        } else {
                            System.out.println("Invalid Password.");
                        }
                        break;
                    case MAIN_MENU_EXIT:
                        System.out.println("Exiting the system...");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}
