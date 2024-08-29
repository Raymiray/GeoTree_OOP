package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда Finish предназначена для завершения работы приложения через пользовательский интерфейс.
 */
public class Finish extends Command {

    /**
     * Конструктор класса Finish.
     */
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершить работу приложения";
    }

    /**
     * Выполняет команду завершения работы приложения, вызывая метод finish в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.finish();
    }
}
