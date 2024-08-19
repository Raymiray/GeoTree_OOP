package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.iterator.ComparatorByAge;
import ru.gb.family_tree.iterator.ComparatorByName;
import ru.gb.family_tree.iterator.FamilyTreeIterator;

import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Класс FamilyTree представляет собой древо семьи, состоящее из объектов класса Human.
 * Предоставляет методы для добавления людей в древо, поиска по идентификатору и имени,
 * а также сортировки и итерации по элементам древа.
 */
public class FamilyTree implements Serializable, Iterable<Human> {

    private long humanId;
    private List<Human> humanList;

    /**
     * Конструктор по умолчанию, инициализирует пустой список людей.
     */
    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    /**
     * Добавляет человека в семейное древо.
     * Если человек уже существует в древе, он не будет добавлен.
     *
     * @param human объект Human для добавления
     * @return true, если человек был успешно добавлен, иначе false
     */
    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);

            addParentsRelations(human);
            addChildrenRelations(human);

            return true;
        }
        return false;
    }

    /**
     * Устанавливает связи между ребенком и родителями.
     *
     * @param human объект Human для установления родительских связей
     */
    private void addParentsRelations(Human human) {
        Human mother = human.getMother();
        if (mother != null) {
            mother.addChild(human);
        }

        Human father = human.getFather();
        if (father != null) {
            father.addChild(human);
        }
    }

    /**
     * Устанавливает связи между родителями и детьми.
     *
     * @param human объект Human для установления детских связей
     */
    private void addChildrenRelations(Human human) {
        if (human.getChildren().size() > 0) {
            for (Human child : human.getChildren()) {
                if (human.getGender() == Gender.female) {
                    child.setMother(human);
                } else {
                    child.setFather(human);
                }
            }
        }
    }

    /**
     * Ищет человека по его идентификатору.
     *
     * @param id идентификатор человека
     * @return объект Human, если найден, иначе null
     */
    public Human findById(long id) {
        for (Human human : humanList) {
            if (human.getId() == id) {
                System.out.println(human);
                return human;
            }
        }
        return null;
    }

    /**
     * Ищет людей по имени.
     *
     * @param name имя для поиска
     * @return список объектов Human с указанным именем
     */
    public List<Human> findByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                res.add(human);
            }
        }
        for (Human human : res) {
            System.out.println(human);
        }
        return res;
    }

    /**
     * Возвращает информацию обо всех людях в семейном древе.
     *
     * @return строка с информацией о людях в древе
     */
    public String getAboutFamily() {
        StringBuilder sb = new StringBuilder();
        sb.append("Humans in family: ");
        sb.append(humanList.size() + "\n\n------------\nThey are:\n\n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
            sb.append("-----------\n");
        }
        return sb.toString();
    }

    /**
     * Возвращает строковое представление семейного древа.
     *
     * @return строка с информацией о семейном древе
     */
    @Override
    public String toString() {
        return getAboutFamily();
    }

    /**
     * Возвращает итератор для обхода семейного древа.
     *
     * @return итератор для семейного древа
     */
    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humanList);
    }

    /**
     * Сортирует список людей в древе по возрасту.
     */
    public void sortByAge() {
        humanList.sort(new ComparatorByAge());
    }

    /**
     * Сортирует список людей в древе по имени.
     */
    public void sortByName() {
        humanList.sort(new ComparatorByName());
    }

}
