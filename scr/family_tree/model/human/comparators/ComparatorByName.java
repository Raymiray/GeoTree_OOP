package family_tree.model.human.comparators;

import family_tree.model.family_tree.FamilyTreeElement;

import java.util.Comparator;

/**
 * Компаратор для сравнения элементов семейного древа по имени.
 */
public class ComparatorByName<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два элемента семейного древа по их именам.
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
