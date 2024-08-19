package ru.gb.family_tree.iterator;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;


public class FamilyTreeIterator implements Iterator<Human> {
    private int idx;
    private List<Human> familyTreeList;

    /**
     * Конструктор для инициализации итератора.
     */
    public FamilyTreeIterator(List<Human> familyTreeList) {
        this.familyTreeList = familyTreeList;
    }

    /**
     * Проверяет, есть ли еще элементы для итерации.
     */
    @Override
    public boolean hasNext() {
        return familyTreeList.size() > idx;
    }

    /**
     * Возвращает следующий элемент в последовательности итерации.
     */
    @Override
    public Human next() {
        return familyTreeList.get(idx++);
    }
}
