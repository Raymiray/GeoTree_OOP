package family_tree.view.commands;

import family_tree.view.ConsoleUI;


public class Read extends Command {
    public Read(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Прочитать информацию по древу из файла \uD83D\uDCE4";
    }

    @Override
    public void execute() {
        consoleUI.read();
    }
}


//-------------------------------------------------------
