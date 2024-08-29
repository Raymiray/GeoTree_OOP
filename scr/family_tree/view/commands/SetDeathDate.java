package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда SetDeathDate предназначена для установки даты смерти члена семьи.
 */
public class SetDeathDate extends Command {

    /**
     * Конструктор класса SetDeathDate.
     */
    public SetDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Обозначить дату смерти члена семьи \uD83E\uDEA6";
    }

    /**
     * Выполняет команду установки даты смерти, вызывая метод setDeathDate
     * в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.setDeathDate();
    }
}
