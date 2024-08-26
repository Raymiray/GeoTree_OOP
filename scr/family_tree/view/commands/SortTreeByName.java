package family_tree.view.commands;

import family_tree.view.ConsoleUI;


public class SortTreeByName extends Command {
    public SortTreeByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список членов семьи в порядке сортировки по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortTreeByName();
    }
}


//-----------------------------------------------------