package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

/**
 * Класс FamilyTree представляет семейное древо.
 * Содержит методы для добавления и поиска людей в семейном древе.
 */
public class FamilyTree implements Serializable {

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
     *
     * @param human человек, которого необходимо добавить
     * @return true, если человек был успешно добавлен, false если человек уже существует в древе или null
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
     * Добавляет родственные отношения родителей для данного человека.
     *
     * @param human человек, для которого добавляются родственные отношения родителей
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
     * Добавляет родственные отношения детей для данного человека.
     *
     * @param human человек, для которого добавляются родственные отношения детей
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
     * Ищет человека в семейном древе по идентификатору.
     *
     * @param id идентификатор человека
     * @return найденный человек или null, если человек не найден
     */
    public Human findById(long id) {
        for (Human human: humanList) {
            if (human.getId() == id) {
                System.out.println(human);
                return human;
            }
        }
        return null;
    }

    /**
     * Ищет людей в семейном древе по имени.
     *
     * @param name имя человека
     * @return список найденных людей с данным именем
     */
    public List<Human> findByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human: humanList) {
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
     * Возвращает строку с информацией о всех людях в семейном древе.
     *
     * @return строка с информацией о семейном древе
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

    @Override
    public String toString() {
        return getAboutFamily();
    }
}
