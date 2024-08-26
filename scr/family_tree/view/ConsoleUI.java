package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.model.human.SpouseStatus;
import family_tree.presenter.Presenter;
import family_tree.view.menus.Menu;
import family_tree.view.menus.MainMenu;
import family_tree.view.menus.SortMenu;

import java.time.LocalDate;
import java.util.Scanner;


public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Введено некорректное значение!";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu main_menu;
    private SortMenu sort_menu;


    public ConsoleUI() {
        toGreet();
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        main_menu = new MainMenu(this);
        sort_menu = new SortMenu(this);
    }


    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }


    @Override
    public void start() {
        while (work) {
            System.out.println("\nДоступные команды:\n------------------ ");
            printMenu(main_menu);
            execute(main_menu);
        }
    }


    public void finish() {
        System.out.println("Работа приложения завершена.");
        work = false;
    }


    public void getAboutFamily() {
        System.out.println("\nДополнительные опции к выбранной команде\nпо выводу всех членов семьи из древа:\n------------------ ");
        printMenu(sort_menu);
        execute(sort_menu);
    }


    public void getNoSortTree(){ presenter.getAboutFamily();
    }


    public void sortTreeByAge() {
        presenter.sortTreeByAge();
    }


    public void sortTreeByName() {
        presenter.sortTreeByName();
    }


    public void addMember() {
        System.out.println("Введите ФИО: ");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения (в формате гггг-мм-дд): ");
        String dateString = scanner.nextLine();
        System.out.println("Введите пол (female/male): ");
        Gender gender = Gender.valueOf(scanner.nextLine());

        presenter.addMember(name, gender, dateString);
    }


    public void setDeathDate() {
        this.getNoSortTree();
        System.out.println("----------------");
        System.out.println("Введите id члена семьи, для которого надо указать дату смерти. Id можно увидеть в списке выше.");
        int personId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите дату смерти (в формате гггг-мм-дд): ");
        LocalDate dod = LocalDate.parse(scanner.nextLine());
        presenter.setDeathDate(personId, dod);
    }


    public void setParent() {

        this.getNoSortTree();
        System.out.println("Введите id члена семьи, для которого надо указать родителя. Id можно увидеть в списке выше");
        int memberId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id родителя. Id можно увидеть в списке выше");
        int parentId = Integer.parseInt(scanner.nextLine());
        presenter.setParent(memberId, parentId);
    }


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


    public void read() {
        System.out.println("Укажите путь к файлу для чтения информации по дереву\n(Например: src/family_tree/model/tools/writer/family_tree.out): ");
        String path = scanner.nextLine();
        while (!presenter.read(path)) {
            System.out.println("Не удалось загрузить файл. Пробовать снова? y/n: ");
            if (scanner.nextLine().equals("n")) {
                break;
            }
            System.out.println("Укажите путь к файлу для чтения информации по дереву\n(Например: src/family_tree/model/tools/writer/family_tree.out): ");
            path = scanner.nextLine();
        }
    }


    public void write() {
        System.out.println("Укажите путь к файлу для сохранения информации по дереву\n(Например: src/family_tree/model/tools/writer/family_tree.out): ");
        String path = scanner.nextLine();
        while(!presenter.write(path)) {
            System.out.println("Не удалось сохранить файл. Пробовать снова? y/n");
            if(scanner.nextLine().equals("n")) {
                break;
            }
            System.out.println("Укажите путь к файлу для сохранения информации по дереву\n(Например: src/family_tree/model/tools/writer/family_tree.out): ");
            path = scanner.nextLine();
        }
    }


    private void toGreet() {
        System.out.println("\nДобро пожаловать в приложение по составлению семейного древа!");
        System.out.println("-------------------------\n-------------------------\n");
    }


    private void execute(Menu menu) {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, menu)) {
                menu.execute(numCommand);
            }
        }
    }


    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }


    private boolean checkCommand(int numCommand, Menu menu) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(Menu menu) {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }
}

