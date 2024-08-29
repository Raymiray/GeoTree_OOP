package family_tree.model.family_tree;

import family_tree.model.human.Gender;
import family_tree.model.human.SpouseStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Интерфейс FamilyTreeElement представляет элемент семейного древа.
 */
public interface FamilyTreeElement<T> extends Serializable {

    /**
     * Возвращает уникальный идентификатор элемента.
     */
    long getId();

    /**
     * Устанавливает уникальный идентификатор элемента.
     */
    void setId(long id);

    /**
     * Возвращает имя элемента.
     */
    String getName();

    /**
     * Устанавливает имя элемента.
     */
    void setName(String name);

    /**
     * Возвращает дату рождения элемента.
     */
    LocalDate getDob();

    /**
     * Устанавливает дату рождения элемента.
     */
    void setDob(LocalDate dob);

    /**
     * Возвращает дату смерти элемента.
     */
    LocalDate getDod();

    /**
     * Устанавливает дату смерти элемента.
     */
    void setDod(LocalDate dod);

    /**
     * Возвращает пол элемента.
     */
    Gender getGender();

    /**
     * Устанавливает пол элемента.
     */
    void setGender(Gender gender);

    /**
     * Возвращает список детей элемента.
     */
    List<T> getChildren();

    /**
     * Добавляет ребенка к элементу.
     */
    boolean addChild(T child);

    /**
     * Возвращает информацию о детях элемента.
     */
    String getChildrenAbout();

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
     * Добавляет родителя к элементу.
     */
    void addParent(T parent);

    /**
     * Возвращает супруга(-у) элемента и их статус.
     */
    HashMap<T, SpouseStatus> getSpouse();

    /**
     * Добавляет супруга(-у) к элементу.
     */
    void addSpouse(T spouse, SpouseStatus status);

    /**
     * Возвращает информацию о супругах элемента.
     */
    String getSpousesAbout();

    /**
     * Возвращает возраст элемента.
     */
    int getAge();

    /**
     * Возвращает статус жизни элемента.
     */
    String getLifeStatus();

    /**
     * Возвращает информацию об элементе.
     */
    String getAbout();
}
