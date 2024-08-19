package ru.gb.family_tree.iterator;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;


public class ComparatorByAge implements Comparator<Human> {
    /**
     * Сравнивает два объекта Human по их возрасту.
     */
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}