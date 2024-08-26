package family_tree.view.commands;

import family_tree.view.ConsoleUI;


public class AddMember extends Command {
    public AddMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить члена семьи \uD83D\uDC64";
    }

    @Override
    public void execute() {
        consoleUI.addMember();
    }
}


//----------------------------------------------------------------
