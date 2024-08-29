package family_tree.view.menus;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.*;

/**
 * Главное меню MainMenu представляет собой меню с основными командами для работы с приложением.
 */
public class MainMenu extends Menu {

    /**
     * Конструктор класса MainMenu.
     */
    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetAboutFamily(consoleUI));
        commandList.add(new AddMember(consoleUI));
        commandList.add(new SetDeathDate(consoleUI));
        commandList.add(new SetParent(consoleUI));
        commandList.add(new SetSpouse(consoleUI));
        commandList.add(new Read(consoleUI));
        commandList.add(new Write(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
