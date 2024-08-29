package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда SortTreeByName предназначена для вывода списка членов семьи, отсортированного по имени.
 */
public class SortTreeByName extends Command {

    /**
     * Конструктор класса SortTreeByName.
     */
    public SortTreeByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список членов семьи в порядке сортировки по имени";
    }

    /**
     * Выполняет команду сортировки списка членов семьи по имени, вызывая метод sortTreeByName
     * в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.sortTreeByName();
    }
}
