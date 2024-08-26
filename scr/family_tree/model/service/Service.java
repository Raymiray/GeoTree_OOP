package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.human.Gender;
import family_tree.model.human.SpouseStatus;
import family_tree.model.tools.writer.FileHandler;

import java.time.LocalDate;

/**
 * Сервисный класс для работы с семейным деревом.
 * <p>
 * Этот класс предоставляет методы для управления членами семьи,
 * а также для чтения и записи данных в файл.
 * </p>
 */
public class Service {
    private FamilyTree<Human> tree;
    private FileHandler<Human> fileHandler = new FileHandler<>();

    /**
     * Конструктор, который инициализирует пустое семейное дерево.
     */
    public Service() {
        tree = new FamilyTree<>();
    }

    /**
     * Чтение семейного дерева из файла.
     */
    public boolean read(String path) {
        FamilyTree<Human> treeRead = fileHandler.read(path);
        if (treeRead == null) {
            return false;
        }
        tree = treeRead;
        return true;
    }

    /**
     * Запись семейного дерева в файл.
     */
    public boolean write(String path) {
        return fileHandler.write(tree, path);
    }

    /**
     * Добавление нового члена семьи.
     */
    public boolean addMember(String name, Gender gender, String date) {
        Human human = new Human(name, gender, date);
        tree.addMember(human);
        return true;
    }

    /**
     * Установка даты смерти для члена семьи.
     */
    public void setDeathDate(int personId, LocalDate dod) {
        Human human = tree.findById(personId);
        human.setDod(dod);
    }

    /**
     * Установка родителя для члена семьи.
     */
    public void setParent(int memberId, int parentId) {
        Human human = tree.findById(memberId);
        human.addParent(tree.findById(parentId));
    }

    /**
     * Установка супруга/супруги для члена семьи.
     */
    public void setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        Human human = tree.findById(firstMemberId);
        human.addSpouse(tree.findById(secondMemberId), spouseStatus);
    }

    /**
     * Проверка существования члена семьи по идентификатору.
     */
    public boolean checkById(int id) {
        return tree.checkById(id);
    }

    /**
     * Получение строки, представляющей семейное дерево.
     */
    public String getAboutFamily() {
        return tree.toString();
    }

    /**
     * Сортировка членов семьи по возрасту и получение строки, представляющей отсортированное дерево.
     */
    public String sortTreeByAge() {
        tree.sortByAge();
        return tree.toString();
    }

    /**
     * Сортировка членов семьи по имени и получение строки, представляющей отсортированное дерево.
     */
    public String sortTreeByName() {
        tree.sortByName();
        return tree.toString();
    }
}
