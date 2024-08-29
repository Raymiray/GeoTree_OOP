package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда Write сохраняет информацию о древе в файл.
 */
public class Write extends Command {

    /**
     * Конструктор класса Write.
     */
    public Write(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить информацию по древу в файл \uD83D\uDCE5";
    }

    /**
     * Выполняет команду сохранения информации о древе в файл, вызывая метод Write
     * в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.write();
    }
}
