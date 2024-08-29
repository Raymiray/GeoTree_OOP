package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда SortTreeByAge предназначена для вывода списка членов семьи, отсортированного по возрасту.
 */
public class SortTreeByAge extends Command {

    /**
     * Конструктор класса SortTreeByAge.
     */
    public SortTreeByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список членов семьи в порядке сортировки по возрасту";
    }

    /**
     * Выполняет команду сортировки списка членов семьи по возрасту, вызывая метод sortTreeByAge
     * в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.sortTreeByAge();
    }
}
