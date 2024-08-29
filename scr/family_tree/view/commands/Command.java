package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Класс Command представляет собой базовый класс для всех команд,
 * которые могут быть выполнены в пользовательском интерфейсе.
 */
public abstract class Command {
    /**
     * Описание команды, которое может быть отображено пользователю.
     */
    String description;

    /**
     * Экземпляр  ConsoleUI, используемый для взаимодействия с пользовательским интерфейсом.
     */
    ConsoleUI consoleUI;

    /**
     * Конструктор класса Command.
     */
    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    /**
     * Возвращает описание команды.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Выполняет команду.
     */
    public abstract void execute();
}
