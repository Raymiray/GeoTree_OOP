package family_tree.view.menus;

import family_tree.view.ConsoleUI;

import family_tree.view.commands.*;


public class MainMenu extends Menu {
    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetAboutFamily(consoleUI));
        commandList.add(new AddMember(consoleUI));
        commandList.add(new SetDeathDate(consoleUI));
        commandList.add(new SetParent(consoleUI));
        commandList.add(new SetSpouse(consoleUI));
        commandList.add(new Read(consoleUI));
        commandList.add(new Write(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}


//-------------------------------------------------------
