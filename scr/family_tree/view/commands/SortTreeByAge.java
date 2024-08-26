package family_tree.view.commands;

import family_tree.view.ConsoleUI;


public class SortTreeByAge extends Command {
    public SortTreeByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список членов семьи в порядке сортировки по возрасту";
    }

    @Override
    public void execute() {
        consoleUI.sortTreeByAge();
    }
}


//-----------------------------------------------------------------
