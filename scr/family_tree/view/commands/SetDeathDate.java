package family_tree.view.commands;

import family_tree.view.ConsoleUI;


public class SetDeathDate extends Command {
    public SetDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Обозначить дату смерти члена семьи \uD83E\uDEA6";
    }

    @Override
    public void execute() {
        consoleUI.setDeathDate();
    }
}


//---------------------------------------------------