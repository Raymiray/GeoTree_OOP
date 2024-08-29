package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда SetParent предназначена для установки родителя для члена семьи.
 */
public class SetParent extends Command {

    /**
     * Конструктор класса SetParent.
     */
    public SetParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителя \uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC66";
    }

    /**
     * Выполняет команду установки родителя, вызывая метод setParent
     * в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.setParent();
    }
}
