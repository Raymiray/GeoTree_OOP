package family_tree.model.human.comparators;

import family_tree.model.family_tree.FamilyTreeElement;

import java.util.Comparator;

/**
 * Класс ComparatorByName сравнивает элементы семейного древа по имени.
 */
public class ComparatorByName<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два элемента семейного древа по их имени.
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
