package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда Read предназначена для чтения информации о древе из файла.

 */
public class Read extends Command {

    /**
     * Конструктор класса Read.
     */
    public Read(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Прочитать информацию по древу из файла \uD83D\uDCE4";
    }

    /**
     * Выполняет команду чтения информации о древе из файла, вызывая метод read
     * в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.read();
    }
}
