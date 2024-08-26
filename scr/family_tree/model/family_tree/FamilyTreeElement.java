package family_tree.model.family_tree;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.human.SpouseStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Интерфейс для элементов генеалогического древа.
 */
public interface FamilyTreeElement<T> extends Serializable {

    /**
     * Возвращает идентификатор элемента.
     */
    long getId();

    /**
     * Устанавливает идентификатор элемента.
     */
    void setId(long id);

    /**
     * Печатает идентификатор элемента.
     */
    void PrintId();

    /**
     * Возвращает имя элемента.
     */
    String getName();

    /**
     * Устанавливает имя элемента.
     */
    void setName(String name);

    /**
     * Печатает имя элемента.
     */
    void PrintName();

    /**
     * Возвращает дату рождения элемента.
     */
    LocalDate getDob();

    /**
     * Устанавливает дату рождения элемента.
     */
    void setDob(LocalDate dob);

    /**
     * Печатает дату рождения элемента.
     */
    void PrintDob();

    /**
     * Возвращает дату смерти элемента.
     */
    LocalDate getDod();

    /**
     * Устанавливает дату смерти элемента.
     */
    void setDod(LocalDate dod);

    /**
     * Печатает дату смерти элемента.
     */
    void PrintDod();

    /**
     * Возвращает пол элемента.
     */
    Gender getGender();

    /**
     * Устанавливает пол элемента.
     */
    void setGender(Gender gender);

    /**
     * Печатает пол элемента.
     */
    void PrintGender();

    /**
     * Возвращает список детей элемента.
     */
    List<T> getChildren();

    /**
     * Добавляет ребенка в список детей элемента.
     */
    boolean addChild(T child);

    /**
     * Возвращает информацию о детях элемента.
     */
    String getChildrenAbout();

    /**
     * Печатает информацию о детях элемента.
     */
    void PrintChildren();

    /**
     * Возвращает мать элемента.
     */
    T getMother();

    /**
     * Устанавливает мать элемента.
     */
    void setMother(T mother);

    /**
     * Возвращает информацию о матери элемента.
     */
    String getMotherAbout();

    /**
     * Печатает информацию о матери элемента.
     */
    void PrintMother();

    /**
     * Возвращает отца элемента.
     */
    T getFather();

    /**
     * Устанавливает отца элемента.
     */
    void setFather(T father);

    /**
     * Возвращает информацию об отце элемента.
     */
    String getFatherAbout();

    /**
     * Печатает информацию об отце элемента.
     */
    void PrintFather();

    /**
     * Добавляет родителя к элементу.
     */
    void addParent(T parent);

    /**
     * Возвращает супругов элемента и их статус.
     */
    HashMap<T, SpouseStatus> getSpouse();

    /**
     * Добавляет супруга к элементу.
     */
    void addSpouse(T spouse, SpouseStatus status);

    /**
     * Возвращает информацию о супругах элемента.
     */
    String getSpousesAbout();

    /**
     * Печатает информацию о супругах элемента.
     */
    void PrintSpouses();

    /**
     * Возвращает возраст элемента.
     */
    int getAge();

    /**
     * Возвращает статус жизни элемента.
     */
    String getLifeStatus();

    /**
     * Печатает возраст элемента.
     */
    void PrintAge();

    /**
     * Возвращает информацию об элементе.
     */
    String getAbout();
}
