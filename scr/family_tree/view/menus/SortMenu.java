package family_tree.view.menus;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.GetNoSortTree;
import family_tree.view.commands.SortTreeByAge;
import family_tree.view.commands.SortTreeByName;

/**
 * Меню сортировки SortMenu предоставляет команды для сортировки списка членов семьи.
 */
public class SortMenu extends Menu {

    /**
     * Конструктор класса SortMenu.
     */
    public SortMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetNoSortTree(consoleUI));
        commandList.add(new SortTreeByAge(consoleUI));
        commandList.add(new SortTreeByName(consoleUI));
    }
}
