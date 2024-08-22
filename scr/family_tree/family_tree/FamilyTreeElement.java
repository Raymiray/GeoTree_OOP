package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.SpouseStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Интерфейс для элемента семейного дерева.
 */
public interface FamilyTreeElement<T> extends Serializable {

    /**
     * Получает идентификатор элемента.
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
     * Получает имя элемента.
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
     * Получает дату рождения элемента.
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
     * Получает дату смерти элемента.
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
     * Получает пол элемента.
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
     * Получает список детей элемента.
     */
    List<T> getChildren();

    /**
     * Добавляет ребенка элементу.
     */
    boolean addChild(T child);

    /**
     * Получает описание детей элемента.
     */
    String getChildrenAbout();

    /**
     * Печатает описание детей элемента.
     */
    void PrintChildren();

    /**
     * Получает мать элемента.
     */
    T getMother();

    /**
     * Устанавливает мать элемента.
     */
    void setMother(T mother);

    /**
     * Получает описание матери элемента.
     */
    String getMotherAbout();

    /**
     * Печатает описание матери элемента.
     */
    void PrintMother();

    /**
     * Получает отца элемента.
     */
    T getFather();

    /**
     * Устанавливает отца элемента.
     */
    void setFather(T father);

    /**
     * Получает описание отца элемента.
     */
    String getFatherAbout();

    /**
     * Печатает описание отца элемента.
     */
    void PrintFather();

    /**
     * Получает список супругов элемента с их статусами.
     */
    HashMap<T, SpouseStatus> getSpouse();

    /**
     * Добавляет супруга элементу.
     */
    boolean addSpouse(T spouse, SpouseStatus status);

    /**
     * Получает описание супругов элемента.
     */
    String getSpousesAbout();

    /**
     * Печатает описание супругов элемента.
     */
    void PrintSpouses();

    /**
     * Получает возраст элемента.
     */
    int getAge();

    /**
     * Получает статус жизни элемента.
     */
    String getLifeStatus();

    /**
     * Печатает возраст элемента.
     */
    void PrintAge();

    /**
     * Получает описание элемента.
     */
    String getAbout();
}
