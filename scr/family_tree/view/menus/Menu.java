package family_tree.view.menus;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

import java.util.List;
import java.util.ArrayList;

/**
 * Класс Menu представляет собой абстрактное меню, которое содержит список команд
 * и предоставляет методы для отображения меню и выполнения выбранной команды.
 */
public class Menu {
    /**
     * Список команд, доступных в меню.
     */
    List<Command> commandList;

    /**
     * Конструктор класса Menu.
     */
    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
    }

    /**
     * Возвращает строковое представление меню с перечнем доступных команд.
     */
    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Выполняет команду по выбранному индексу.
     */
    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    /**
     * Возвращает количество команд в меню.
     */
    public int getSize() {
        return commandList.size();
    }
}
