package ru.gb.family_tree.iterator;

import ru.gb.family_tree.family_tree.FamilyTreeElement;

import java.util.Iterator;
import java.util.List;

/**
 * Итератор для обхода элементов семейного древа.
 */
public class FamilyTreeIterator<E extends FamilyTreeElement<E>> implements Iterator<E> {
    private int idx;
    private List<E> familyTreeList;

    /**
     * Конструктор для создания итератора семейного древа.
     */
    public FamilyTreeIterator(List<E> familyTreeList) {
        this.familyTreeList = familyTreeList;
        idx = 0;
    }

    /**
     * Проверяет, есть ли следующий элемент в списке.
     */
    @Override
    public boolean hasNext() {
        return familyTreeList.size() > idx;
    }

    /**
     * Возвращает следующий элемент из списка.
     */
    @Override
    public E next() {
        return familyTreeList.get(idx++);
    }
}
