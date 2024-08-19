package ru.gb.family_tree.iterator;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;


public class ComparatorByName implements Comparator<Human> {
    /**
     * Сравнивает два объекта Human по их имени.
     */
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}