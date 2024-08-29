package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда SetSpouse предназначена для установки супруга(и) для члена семьи.
 */
public class SetSpouse extends Command {

    /**
     * Конструктор класса SetSpouse.
     */
    public SetSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить супруга(у) \uD83D\uDC6B";
    }

    /**
     * Выполняет команду установки супруга(и), вызывая метод setSpouse
     * в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.setSpouse();
    }
}
