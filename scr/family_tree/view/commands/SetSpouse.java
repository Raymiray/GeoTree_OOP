package family_tree.view.commands;

import family_tree.view.ConsoleUI;


public class SetSpouse extends Command {

    public SetSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить супруга(у) \uD83D\uDC6B";
    }

    @Override
    public void execute() {
        consoleUI.setSpouse();
    }
}


//---------------------------------------------------