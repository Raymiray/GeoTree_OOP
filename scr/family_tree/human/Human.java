package ru.gb.family_tree.human;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.Period;

/**
 * Класс Human представляет человека с различными атрибутами и родственными связями.
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
     * Конструктор для создания человека с полными данными.
     *
     * @param name имя человека
     * @param gender гендер человека
     * @param dob дата рождения
     * @param dod дата смерти
     * @param mother мать
     * @param father отец
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
     * Конструктор для создания живого человека с родителями.
     *
     * @param name имя человека
     * @param gender гендер человека
     * @param dob дата рождения
     * @param mother мать
     * @param father отец
     */
    public Human(String name, Gender gender, LocalDate dob, Human mother, Human father) {
        this(name, gender, dob, null, mother, father);
    }

    /**
     * Конструктор для создания человека с данными о смерти, но без родителей.
     *
     * @param name имя человека
     * @param gender гендер человека
     * @param dob дата рождения
     * @param dod дата смерти
     */
    public Human(String name, Gender gender, LocalDate dob, LocalDate dod) {
        this(name, gender, dob, dod, null, null);
    }

    /**
     * Конструктор для создания живого человека без родителей.
     *
     * @param name имя человека
     * @param gender гендер человека
     * @param dob дата рождения
     */
    public Human(String name, Gender gender, LocalDate dob) {
        this(name, gender, dob, null, null, null);
    }

    // Геттеры и сеттеры

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public HashMap<Human, SpouseStatus> getSpouse() {
        return spouses;
    }

    public boolean addSpouse(Human spouse, SpouseStatus status) {
        if (this.spouses.containsKey(spouse)) {
            return false;
        } else {
            this.spouses.put(spouse, status);
        }
        return true;
    }

    // Методы для вывода информации о человеке

    public void PrintId() {
        System.out.println("Id: " + this.getId());
    }

    public void PrintName() {
        System.out.println("Surname Name Patronymic: " + this.getName());
    }

    public void PrintDob() {
        System.out.println("Date of Birth (year-month-day): " + this.getDob());
    }

    public void PrintDod() {
        if (dod == null) {
            System.out.println("Is alive");
        } else {
            System.out.println("Date of Death (year-month-day): " + this.getDod());
        }
    }

    public void PrintGender() {
        System.out.println("Gender: " + this.getGender());
    }

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

    public void PrintChildren() {
        System.out.println(getChildrenAbout());
    }

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

    public void PrintMother() {
        System.out.println(getMotherAbout());
    }

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

    public void PrintFather() {
        System.out.println(getFatherAbout());
    }

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

    public void PrintSpouses() {
        System.out.println(getSpousesAbout());
    }

    private int getInterval(LocalDate dob, LocalDate dod) {
        Period interval = Period.between(dob, dod);
        return interval.getYears();
    }

    public int getAge() {
        if (dod == null) {
            return getInterval(dob, LocalDate.now());
        } else {
            return getInterval(dob, dod);
        }
    }

    public String getLifeStatus() {
        if (dod == null) {
            return "Alive";
        } else {
            return "Dead";
        }
    }

    public void PrintAge() {
        if (dod == null) {
            System.out.println(getLifeStatus() + ", age is: " + this.getAge());
        } else {
            System.out.println(getLifeStatus() + ", age was: " + this.getAge());
        }
    }

    @Override
    public String toString() {
        return getAbout();
    }

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
