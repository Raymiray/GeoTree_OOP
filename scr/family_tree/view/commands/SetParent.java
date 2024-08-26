package family_tree.view.commands;

import family_tree.view.ConsoleUI;


public class SetParent extends Command {

    public SetParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителя \uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC66";
    }

    @Override
    public void execute() {
        consoleUI.setParent();
    }
}


//---------------------------------------------------