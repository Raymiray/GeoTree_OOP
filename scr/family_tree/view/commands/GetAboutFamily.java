package family_tree.view.commands;

import family_tree.view.ConsoleUI;

/**
 * Команда  GetAboutFamily предназначена для вывода списка всех членов семьи из древа.
 */
public class GetAboutFamily extends Command {

    /**
     * Конструктор класса GetAboutFamily.
     */
    public GetAboutFamily(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список всех членов семьи из древа \uD83D\uDCDD";
    }

    /**
     * Выполняет команду получения информации о всех членах семьи, вызывая метод getAboutFamily
     * в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.getAboutFamily();
    }
}
