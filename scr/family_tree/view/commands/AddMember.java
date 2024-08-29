package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда AddMember предназначена для добавления нового члена семьи через пользовательский интерфейс.
 */
public class AddMember extends Command {

    /**
     * Конструктор класса AddMember.
     */
    public AddMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить члена семьи \uD83D\uDC64";
    }

    /**
     * Выполняет команду добавления нового члена семьи, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.addMember();
    }
}
