package ru.gb.family_tree.iterator;

import ru.gb.family_tree.family_tree.FamilyTreeElement;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

/**
 * Класс ComparatorByName реализует интерфейс Comparator для сравнения объектов,
 * которые являются элементами семейного древа, по их именам.
 */
public class ComparatorByName<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два объекта типа E по их именам.
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
