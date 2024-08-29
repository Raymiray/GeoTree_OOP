package family_tree.model.human.comparators;

import family_tree.model.family_tree.FamilyTreeElement;

import java.util.Comparator;

/**
 * Класс ComparatorByAge сравнивает элементы семейного древа по возрасту.
 */
public class ComparatorByAge<E extends FamilyTreeElement<E>> implements Comparator<E> {

    /**
     * Сравнивает два элемента семейного древа по их возрасту.
     */
    @Override
    public int compare(E o1, E o2) {
        return o1.getAge() - o2.getAge();
    }
}
