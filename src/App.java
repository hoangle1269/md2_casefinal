import Controller.MainMenu;
import Utils.BooksInitializer;

public class App {

    public static void main(String[] args) {
        BooksInitializer.initializeBooks();
        MainMenu mainMenu = new MainMenu();
        mainMenu.displayMainMenu();
    }
}
