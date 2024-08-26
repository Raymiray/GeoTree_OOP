package family_tree.view.menus;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.GetNoSortTree;
import family_tree.view.commands.SortTreeByAge;
import family_tree.view.commands.SortTreeByName;


public class SortMenu extends Menu {
    public SortMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetNoSortTree(consoleUI));
        commandList.add(new SortTreeByAge(consoleUI));
        commandList.add(new SortTreeByName(consoleUI));
    }
}


//-------------------------------------------------------
