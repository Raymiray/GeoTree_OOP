package family_tree.view.commands;

import family_tree.view.ConsoleUI;


public class Finish extends Command {

    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершить работу приложения";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}


//-----------------------------------------------------------
