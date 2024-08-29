package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда GetNoSortTree предназначена для вывода неотсортированного списка членов семьи.
 */
public class GetNoSortTree extends Command {

    /**
     * Конструктор класса GetNoSortTree.
     */
    public GetNoSortTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести неотсортированный список членов семьи";
    }

    /**
     * Выполняет команду получения неотсортированного списка членов семьи, вызывая метод getNoSortTree
     * в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.getNoSortTree();
    }
}
