package ru.gb.family_tree.human;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.Period;

/**
 * Класс представляет человека с его личной информацией и семейными связями.
 */
public class Human implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob, dod;
    private List<Human> children;
    private Human mother, father;
    private HashMap<Human, SpouseStatus> spouses = new HashMap<>();

    /**
     * Конструктор для создания объекта Human с полной информацией.
     *
     * @param name   Имя человека.
     * @param gender Пол человека.
     * @param dob    Дата рождения.
     * @param dod    Дата смерти (может быть null, если человек жив).
     * @param mother Мать человека.
     * @param father Отец человека.
     */
    public Human(String name, Gender gender, LocalDate dob, LocalDate dod, Human mother, Human father) {
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.dod = dod;
        this.children = new ArrayList<>();
        this.mother = mother;
        this.father = father;
        this.spouses = new HashMap<>();
    }

    /**
     * Конструктор для создания объекта Human без даты смерти.
     *
     * @param name   Имя человека.
     * @param gender Пол человека.
     * @param dob    Дата рождения.
     * @param mother Мать человека.
     * @param father Отец человека.
     */
    public Human(String name, Gender gender, LocalDate dob, Human mother, Human father) {
        this(name, gender, dob, null, mother, father);
    }

    /**
     * Конструктор для создания объекта Human без родителей.
     *
     * @param name   Имя человека.
     * @param gender Пол человека.
     * @param dob    Дата рождения.
     * @param dod    Дата смерти (может быть null, если человек жив).
     */
    public Human(String name, Gender gender, LocalDate dob, LocalDate dod) {
        this(name, gender, dob, dod, null, null);
    }

    /**
     * Конструктор для создания объекта Human только с основной информацией.
     *
     * @param name   Имя человека.
     * @param gender Пол человека.
     * @param dob    Дата рождения.
     */
    public Human(String name, Gender gender, LocalDate dob) {
        this(name, gender, dob, null, null, null);
    }

    /**
     * Возвращает уникальный идентификатор человека.
     *
     * @return Идентификатор человека.
     */
    public long getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор человека.
     *
     * @param id Идентификатор человека.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Печатает идентификатор человека.
     */
    public void PrintId() {
        System.out.println("Id: " + this.getId());
    }

    /**
     * Возвращает имя человека.
     *
     * @return Имя человека.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя человека.
     *
     * @param name Имя человека.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Печатает имя человека.
     */
    public void PrintName() {
        System.out.println("Surname Name Patronymic: " + this.getName());
    }

    /**
     * Возвращает дату рождения человека.
     *
     * @return Дата рождения человека.
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Устанавливает дату рождения человека.
     *
     * @param dob Дата рождения человека.
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * Печатает дату рождения человека.
     */
    public void PrintDob() {
        System.out.println("Date of Birth (year-month-day): " + this.getDob());
    }

    /**
     * Возвращает дату смерти человека.
     *
     * @return Дата смерти человека (может быть null, если человек жив).
     */
    public LocalDate getDod() {
        return dod;
    }

    /**
     * Устанавливает дату смерти человека.
     *
     * @param dod Дата смерти человека.
     */
    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    /**
     * Печатает дату смерти человека или сообщение о том, что он жив.
     */
    public void PrintDod() {
        if (dod == null) {
            System.out.println("Is alive");
        } else {
            System.out.println("Date of Death (year-month-day): " + this.getDod());
        }
    }

    /**
     * Возвращает пол человека.
     *
     * @return Пол человека.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Устанавливает пол человека.
     *
     * @param gender Пол человека.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Печатает пол человека.
     */
    public void PrintGender() {
        System.out.println("Gender: " + this.getGender());
    }

    /**
     * Возвращает список детей человека.
     *
     * @return Список детей человека.
     */
    public List<Human> getChildren() {
        return children;
    }

    /**
     * Добавляет ребенка в список детей человека.
     *
     * @param child Ребенок.
     * @return true, если ребенок успешно добавлен, иначе false.
     */
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    /**
     * Возвращает строковое представление списка детей.
     *
     * @return Список детей в строковом формате.
     */
    public String getChildrenAbout() {
        StringBuilder childrenAbout = new StringBuilder();
        childrenAbout.append("Children: ");
        if (children.size() > 0) {
            childrenAbout.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                childrenAbout.append(", ");
                childrenAbout.append(children.get(i).getName());
            }
        } else {
            childrenAbout.append("None");
        }
        return childrenAbout.toString();
    }

    /**
     * Печатает список детей.
     */
    public void PrintChildren() {
        System.out.println(getChildrenAbout());
    }

    /**
     * Возвращает мать человека.
     *
     * @return Мать человека.
     */
    public Human getMother() {
        return mother;
    }

    /**
     * Устанавливает мать человека.
     *
     * @param mother Мать человека.
     */
    public void setMother(Human mother) {
        this.mother = mother;
    }

    /**
     * Возвращает строковое представление информации о матери человека.
     *
     * @return Информация о матери в строковом формате.
     */
    public String getMotherAbout() {
        String motherAbout = "Mother: ";
        Human mother = getMother();
        if (mother == null) {
            motherAbout += "Unknown";
        } else {
            motherAbout += mother.getName();
        }
        return motherAbout;
    }

    /**
     * Печатает информацию о матери человека.
     */
    public void PrintMother() {
        System.out.println(getMotherAbout());
    }

    /**
     * Возвращает отца человека.
     *
     * @return Отец человека.
     */
    public Human getFather() {
        return father;
    }

    /**
     * Устанавливает отца человека.
     *
     * @param father Отец человека.
     */
    public void setFather(Human father) {
        this.father = father;
    }

    /**
     * Возвращает строковое представление информации об отце человека.
     *
     * @return Информация об отце в строковом формате.
     */
    public String getFatherAbout() {
        String fatherAbout = "Father: ";
        Human father = getFather();
        if (father == null) {
            fatherAbout += "Unknown";
        } else {
            fatherAbout += father.getName();
        }
        return fatherAbout;
    }

    /**
     * Печатает информацию об отце человека.
     */
    public void PrintFather() {
        System.out.println(getFatherAbout());
    }

    /**
     * Возвращает список супругов человека и их статус.
     *
     * @return Список супругов и их статус.
     */
    public HashMap<Human, SpouseStatus> getSpouse() {
        return spouses;
    }

    /**
     * Добавляет супруга и его статус.
     *
     * @param spouse Супруг.
     * @param status Статус супруга.
     * @return true, если супруг успешно добавлен, иначе false.
     */
    public boolean addSpouse(Human spouse, SpouseStatus status) {
        if (this.spouses.containsKey(spouse)) {
            return false;
        } else {
            this.spouses.put(spouse, status);
        }
        return true;
    }

    /**
     * Возвращает строковое представление списка супругов и их статуса.
     *
     * @return Список супругов и их статус в строковом формате.
     */
    public String getSpousesAbout() {
        StringBuilder spousesAbout = new StringBuilder();
        spousesAbout.append("Spouses: ");

        if (!spouses.isEmpty()) {
            boolean first = true;
            for (Map.Entry<Human, SpouseStatus> entry : spouses.entrySet()) {
                if (!first) {
                    spousesAbout.append(", ");
                } else {
                    first = false;
                }
                spousesAbout.append(entry.getKey().getName());
                spousesAbout.append(": ");
                spousesAbout.append(entry.getValue());
            }
        } else {
            spousesAbout.append("None");
        }

        return spousesAbout.toString();
    }

    /**
     * Печатает информацию о супругах.
     */
    public void PrintSpouses() {
        System.out.println(getSpousesAbout());
    }

    /**
     * Вычисляет количество лет между двумя датами.
     *
     * @param dob Дата начала.
     * @param dod Дата окончания.
     * @return Количество лет между датами.
     */
    private int getInterval(LocalDate dob, LocalDate dod) {
        Period interval = Period.between(dob, dod);
        return interval.getYears();
    }

    /**
     * Возвращает текущий возраст человека.
     *
     * @return Возраст человека.
     */
    public int getAge() {
        if (dod == null) {
            return getInterval(dob, LocalDate.now());
        } else {
            return getInterval(dob, dod);
        }
    }

    /**
     * Возвращает статус жизни человека (жив или мертв).
     *
     * @return Статус жизни человека.
     */
    public String getLifeStatus() {
        if (dod == null) {
            return "Alive";
        } else {
            return "Dead";
        }
    }

    /**
     * Печатает текущий возраст и статус жизни человека.
     */
    public void PrintAge() {
        if (dod == null) {
            System.out.println(getLifeStatus() + ", age is: " + this.getAge());
        } else {
            System.out.println(getLifeStatus() + ", age was: " + this.getAge());
        }
    }

    /**
     * Возвращает строковое представление объекта Human.
     *
     * @return Информация о человеке в строковом формате.
     */
    @Override
    public String toString() {
        return getAbout();
    }

    /**
     * Возвращает полную информацию о человеке.
     *
     * @return Полная информация о человеке.
     */
    public String getAbout() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ");
        sb.append(name);
        sb.append("\nGender: ");
        sb.append(getGender());
        sb.append("\nAge: " + getAge() + ". " + getLifeStatus());
        sb.append("\n" + getChildrenAbout());
        sb.append("\n" + getMotherAbout());
        sb.append("\n" + getFatherAbout());
        sb.append("\n" + getSpousesAbout());
        return sb.toString();
    }

    /**
     * Проверяет равенство объектов Human на основе их идентификаторов.
     *
     * @param obj Объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
