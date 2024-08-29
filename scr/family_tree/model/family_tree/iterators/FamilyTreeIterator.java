package family_tree.model.family_tree.iterators;

import family_tree.model.family_tree.FamilyTreeElement;

import java.util.Iterator;
import java.util.List;

/**
 * Итератор для обхода элементов семейного дерева.
 */
public class FamilyTreeIterator<E extends FamilyTreeElement<E>> implements Iterator<E> {
    private int idx;
    private List<E> familyTreeList;

    /**
     * Конструктор инициализирует итератор списком элементов семейного дерева.
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
     * Возвращает следующий элемент в списке.
     */
    @Override
    public E next() {
        return familyTreeList.get(idx++);
    }
}
