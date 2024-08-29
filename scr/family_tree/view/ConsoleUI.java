package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.model.human.SpouseStatus;
import family_tree.presenter.Presenter;
import family_tree.view.menus.Menu;
import family_tree.view.menus.MainMenu;
import family_tree.view.menus.SortMenu;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Класс ConsoleUI представляет собой текстовый пользовательский интерфейс для взаимодействия с пользователем.
 */
public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Введено некорректное значение!";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu main_menu;
    private SortMenu sort_menu;

    /**
     * Конструктор класса ConsoleUI.
     */
    public ConsoleUI() {
        toGreet();
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        main_menu = new MainMenu(this);
        sort_menu = new SortMenu(this);
    }

    /**
     * Выводит текстовое сообщение на экран.
     */
    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    /**
     * Запускает основной цикл работы приложения, отображая главное меню и выполняя выбранные команды.
     */
    @Override
    public void start() {
        while (work) {
            System.out.println("\nДоступные команды:\n------------------ ");
            printMenu(main_menu);
            execute(main_menu);
        }
    }

    /**
     * Завершает работу приложения, выводя сообщение о завершении.
     */
    public void finish() {
        System.out.println("Работа приложения завершена.");
        work = false;
    }

    /**
     * Отображает меню сортировки и выполняет выбранные команды сортировки.
     */
    public void getAboutFamily() {
        System.out.println("\nДополнительные опции к выбранной команде\nпо выводу всех членов семьи из древа:\n------------------ ");
        printMenu(sort_menu);
        execute(sort_menu);
    }

    /**
     * Запрашивает информацию о всех членах семьи и выводит её на экран.
     */
    public void getNoSortTree() {
        presenter.getAboutFamily();
    }

    /**
     * Запрашивает информацию для сортировки списка членов семьи по возрасту и выполняет сортировку.
     */
    public void sortTreeByAge() {
        presenter.sortTreeByAge();
    }

    /**
     * Запрашивает информацию для сортировки списка членов семьи по имени и выполняет сортировку.
     */
    public void sortTreeByName() {
        presenter.sortTreeByName();
    }

    /**
     * Запрашивает информацию для добавления нового члена семьи и добавляет его в дерево.
     */
    public void addMember() {
        System.out.println("Введите ФИО: ");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения (в формате гггг-мм-дд): ");
        String dateString = scanner.nextLine();
        System.out.println("Введите пол (female/male): ");
        Gender gender = Gender.valueOf(scanner.nextLine());

        presenter.addMember(name, gender, dateString);
    }

    /**
     * Запрашивает информацию для установки даты смерти члена семьи и обновляет её.
     */
    public void setDeathDate() {
        this.getNoSortTree();
        System.out.println("----------------");
        System.out.println("Введите id члена семьи, для которого надо указать дату смерти. Id можно увидеть в списке выше.");
        int personId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите дату смерти (в формате гггг-мм-дд): ");
        LocalDate dod = LocalDate.parse(scanner.nextLine());
        presenter.setDeathDate(personId, dod);
    }

    /**
     * Запрашивает информацию для установки родителя члена семьи и обновляет её.
     */
    public void setParent() {
        this.getNoSortTree();
        System.out.println("Введите id члена семьи, для которого надо указать родителя. Id можно увидеть в списке выше");
        int memberId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id родителя. Id можно увидеть в списке выше");
        int parentId = Integer.parseInt(scanner.nextLine());
        presenter.setParent(memberId, parentId);
    }

    /**
     * Запрашивает информацию для установки супруга(и) члена семьи и обновляет её.
     */
    public void setSpouse() {
        this.getNoSortTree();
        System.out.println("Введите id члена семьи, для которого надо указать супруга(у). Id можно увидеть в списке выше");
        int firstMemberId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id супруга(и). Id можно увидеть в списке выше");
        int secondMemberId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите статус супругов (ex/actual): ");
        SpouseStatus spouseStatus = SpouseStatus.valueOf(scanner.nextLine());
        presenter.setSpouse(firstMemberId, secondMemberId, spouseStatus);
    }

    /**
     * Запрашивает путь к файлу для чтения информации по дереву и пытается загрузить данные из указанного файла.
     */
    public void read() {
        System.out.println("Укажите путь к файлу для чтения информации по дереву\n(Например: src/ru/gb/family_tree/model/tools/writer/family_tree.out): ");
        String path = scanner.nextLine();
        while (!presenter.read(path)) {
            System.out.println("Не удалось загрузить файл. Будете пробовать снова? y/n: ");
            if (scanner.nextLine().equals("n")) {
                break;
            }
            System.out.println("Укажите путь к файлу для чтения информации по дереву\n(Например: src/ru/gb/family_tree/model/tools/writer/family_tree.out): ");
            path = scanner.nextLine();
        }
    }

    /**
     * Запрашивает путь к файлу для сохранения информации по дереву и пытается сохранить данные в указанный файл.
     */
    public void write() {
        System.out.println("Укажите путь к файлу для сохранения информации по дереву\n(Например: src/ru/gb/family_tree/model/tools/writer/family_tree.out): ");
        String path = scanner.nextLine();
        while (!presenter.write(path)) {
            System.out.println("Не удалось сохранить файл. Будете пробовать снова? y/n");
            if (scanner.nextLine().equals("n")) {
                break;
            }
            System.out.println("Укажите путь к файлу для сохранения информации по дереву\n(Например: src/ru/gb/family_tree/model/tools/writer/family_tree.out): ");
            path = scanner.nextLine();
        }
    }

    /**
     * Выводит приветственное сообщение при запуске приложения.
     */
    private void toGreet() {
        System.out.println("\nДобро пожаловать в приложение по составлению семейного древа!");
        System.out.println("-------------------------\n-------------------------\n");
    }

    /**
     * Выполняет выбранную команду в указанном меню.
     */
    private void execute(Menu menu) {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, menu)) {
                menu.execute(numCommand);
            }
        }
    }

    /**
     * Проверяет, является ли строка числом.
     */
    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    /**
     * Проверяет, находится ли выбранная команда в пределах допустимого диапазона.
     */
    private boolean checkCommand(int numCommand, Menu menu) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    /**
     * Выводит текстовое представление меню на экран.
     */
    private void printMenu(Menu menu) {
        System.out.println(menu.menu());
    }

    /**
     * Выводит сообщение об ошибке ввода.
     */
    private void inputError() {
        System.out.println(INPUT_ERROR);
    }
}
