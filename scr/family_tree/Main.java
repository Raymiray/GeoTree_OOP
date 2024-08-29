package family_tree;

import family_tree.view.ConsoleUI;

import java.io.IOException;

public class Main {

    /**
     * Точка входа в приложение.
     */
    public static void main(String[] args) throws IOException {
        ConsoleUI app = new ConsoleUI();
        app.start();
    }
}
