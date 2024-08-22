package ru.gb.family_tree.iterator;

import ru.gb.family_tree.family_tree.FamilyTreeElement;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

/**
 * Класс ComparatorByAge реализует интерфейс Comparator для сравнения элементов семейного дерева по возрасту.
 */
public class ComparatorByAge<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два объекта по возрасту.
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
