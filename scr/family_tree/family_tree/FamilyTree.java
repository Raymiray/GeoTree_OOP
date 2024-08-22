package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.iterator.ComparatorByAge;
import ru.gb.family_tree.iterator.ComparatorByName;
import ru.gb.family_tree.iterator.FamilyTreeIterator;

import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Класс FamilyTree представляет собой древо семейных связей.
 */
public class FamilyTree<E extends FamilyTreeElement<E>> implements Serializable, Iterable<E> {

    private long MemberId;
    private final List<E> MemberList;

    /**
     * Конструктор по умолчанию, инициализирующий пустой список членов семьи.
     */
    public FamilyTree() {
        this.MemberList = new ArrayList<>();
    }

    /**
     * Добавляет нового члена семьи в древо.
     */
    public boolean addMember(E member) {
        if (member == null) {
            return false;
        }
        if (!MemberList.contains(member)) {
            MemberList.add(member);
            member.setId(MemberId++);

            addParentsRelations(member);
            addChildrenRelations(member);

            return true;
        }
        return false;
    }

    /**
     * Добавляет отношения родителей для данного члена семьи.
     */
    private void addParentsRelations(E member) {
        E mother = member.getMother();
        if (mother != null) {
            mother.addChild(member);
        }

        E father = member.getFather();
        if (father != null) {
            father.addChild(member);
        }
    }

    /**
     * Добавляет отношения детей для данного члена семьи.
     */
    private void addChildrenRelations(E member) {
        if (member.getChildren().size() > 0) {
            for (E child : member.getChildren()) {
                if (member.getGender() == Gender.female) {
                    child.setMother(member);
                } else {
                    child.setFather(member);
                }
            }
        }
    }

    /**
     * Находит члена семьи по его идентификатору.
     */
    public E findById(long id) {
        for (E member: MemberList) {
            if (member.getId() == id) {
                System.out.println(member);
                return member;
            }
        }
        return null;
    }

    /**
     * Находит членов семьи по имени.
     */
    public List<E> findByName(String name) {
        List<E> res = new ArrayList<>();
        for (E member: MemberList) {
            if (member.getName().equalsIgnoreCase(name)) {
                res.add(member);
            }
        }
        for (E member : res) {
            System.out.println(member);
        }
        return res;
    }

    /**
     * Возвращает информацию о семье.
     */
    public String getAboutFamily() {
        StringBuilder sb = new StringBuilder();
        sb.append("Members in family: ");
        sb.append(MemberList.size() + "\n\n------------\nThey are:\n\n");
        for (E member : MemberList) {
            sb.append(member);
            sb.append("\n");
            sb.append("-----------\n");
        }
        return sb.toString();
    }

    /**
     * Возвращает строковое представление семейного древа.
     */
    @Override
    public String toString() {
        return getAboutFamily();
    }

    /**
     * Возвращает итератор для обхода членов семейного древа.
     */
    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(MemberList);
    }

    /**
     * Сортирует членов семьи по возрасту.
     */
    public void sortByAge() {
        MemberList.sort(new ComparatorByAge<>());
    }

    /**
     * Сортирует членов семьи по имени.
     */
    public void sortByName() {
        MemberList.sort(new ComparatorByName<>());
    }
}
