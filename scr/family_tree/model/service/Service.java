package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.human.Gender;
import family_tree.model.human.SpouseStatus;
import family_tree.model.tools.writer.FileHandler;

import java.time.LocalDate;

/**
 * Класс Service предоставляет методы для управления семейным древом.
 */
public class Service {
    private FamilyTree<Human> tree;
    private FileHandler<Human> fileHandler = new FileHandler<>();

    /**
     * Конструктор по умолчанию. Создает пустое семейное древо.
     */
    public Service() {
        tree = new FamilyTree<>();
    }

    /**
     * Читает семейное древо из файла.
     */
    public boolean read(String path) {
        FamilyTree<Human> treeRead = fileHandler.read(path);
        if (treeRead.equals(null)) {
            return false;
        }
        tree = treeRead;
        return true;
    }

    /**
     * Записывает семейное древо в файл.
     */
    public boolean write(String path) {
        return fileHandler.write(tree, path);
    }

    /**
     * Добавляет нового члена в семейное древо.
     */
    public boolean addMember(String name, Gender gender, String date) {
        Human human = new Human(name, gender, date);
        tree.addMember(human);
        return true;
    }

    /**
     * Устанавливает дату смерти члена семейного древа.
     */
    public void setDeathDate(int personId, LocalDate dod) {
        Human human = tree.findById(personId);
        human.setDod(dod);
    }

    /**
     * Устанавливает родителя для члена семейного древа.
     */
    public void setParent(int memberId, int parentId) {
        Human human = tree.findById(memberId);
        human.addParent(tree.findById(parentId));
    }

    /**
     * Устанавливает супруга для члена семейного древа.
     */
    public void setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        Human human = tree.findById(firstMemberId);
        human.addSpouse(tree.findById(secondMemberId), spouseStatus);
    }

    /**
     * Проверяет наличие члена семейного древа по идентификатору.
     */
    public boolean checkById(int id) {
        return tree.checkById(id);
    }

    /**
     * Возвращает информацию о семейном древе.
     */
    public String getAboutFamily() {
        return tree.toString();
    }

    /**
     * Сортирует семейное древо по возрасту и возвращает его информацию.
     */
    public String sortTreeByAge() {
        tree.sortByAge();
        return tree.toString();
    }

    /**
     * Сортирует семейное древо по имени и возвращает его информацию.
     */
    public String sortTreeByName() {
        tree.sortByName();
        return tree.toString();
    }
}
