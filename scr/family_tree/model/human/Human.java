package family_tree.model.human;

import family_tree.model.family_tree.FamilyTreeElement;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.Period;

/**
 * Класс, представляющий человека.
 */
public class Human implements Serializable, FamilyTreeElement<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob, dod;
    private List<Human> children;
    private Human mother, father;
    private HashMap<Human, SpouseStatus> spouses = new HashMap<>();

    /**
     * Конструктор класса Human.
     */
    public Human(String name, Gender gender, String dob) {
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.dob = LocalDate.parse(dob);
        this.dod = dod;
        this.children = new ArrayList<>();
        this.mother = mother;
        this.father = father;
        this.spouses = new HashMap<>();
    }

    /**
     * Возвращает идентификатор человека.
     */
    public long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор человека.
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
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя человека.
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
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Устанавливает дату рождения человека.
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
     */
    public LocalDate getDod() {
        return dod;
    }

    /**
     * Устанавливает дату смерти человека.
     *
     * @param dod дата смерти человека
     */
    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    /**
     * Печатает дату смерти человека или сообщение о том, что человек жив.
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
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Устанавливает пол человека.
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
     */
    public List<Human> getChildren() {
        return children;
    }

    /**
     * Добавляет ребенка в список детей человека.
     */
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    /**
     * Возвращает строку с описанием детей человека.
     */
    public String getChildrenAbout() {
        StringBuilder childrenAbout = new StringBuilder();
        childrenAbout.append("Children: ");
        if (children.size() > 0) {
            childrenAbout.append(children.getFirst().getName());
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
     * Печатает описание детей человека.
     */
    public void PrintChildren() {
        System.out.println(getChildrenAbout());
    }

    /**
     * Возвращает мать человека.
     */
    public Human getMother() {
        return mother;
    }

    /**
     * Устанавливает мать человека.
     */
    public void setMother(Human mother) {
        this.mother = mother;
    }

    /**
     * Возвращает строку с описанием матери человека.
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
     * Печатает описание матери человека.
     */
    public void PrintMother() {
        System.out.println(getMotherAbout());
    }

    /**
     * Возвращает отца человека.
     */
    public Human getFather() {
        return father;
    }

    /**
     * Устанавливает отца человека.
     */
    public void setFather(Human father) {
        this.father = father;
    }

    /**
     * Возвращает строку с описанием отца человека.
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
     * Печатает описание отца человека.
     */
    public void PrintFather() {
        System.out.println(getFatherAbout());
    }

    /**
     * Добавляет родителя к человеку.
     */
    public void addParent(Human parent) {
        if (parent.gender.equals(Gender.male)) {
            this.setFather(parent);
            if (!parent.getChildren().contains(this)) {
                parent.addChild(this);
            }
        } else if (parent.gender.equals(Gender.female)) {
            this.setMother(parent);
            if (!parent.getChildren().contains(this)) {
                parent.addChild(this);
            }
        }
    }

    /**
     * Возвращает список супругов человека.
     */
    public HashMap<Human, SpouseStatus> getSpouse() {
        return spouses;
    }

    /**
     * Добавляет супруга к человеку.
     */
    public void addSpouse(Human spouse, SpouseStatus status) {
        if (!this.spouses.containsKey(spouse)) {
            this.spouses.put(spouse, status);
            spouse.addSpouse(this, status);
        }
    }

    /**
     * Возвращает строку с описанием супругов человека.
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
     * Печатает описание супругов человека.
     */
    public void PrintSpouses() {
        System.out.println(getSpousesAbout());
    }

    /**
     * Возвращает количество лет между двумя датами.
     */
    private int getInterval(LocalDate dob, LocalDate dod) {
        Period interval = Period.between(dob, dod);
        return interval.getYears();
    }

    /**
     * Возвращает возраст человека.
     */
    public int getAge() {
        if (dod == null) {
            return getInterval(dob, LocalDate.now());
        } else {
            return getInterval(dob, dod);
        }
    }

    /**
     * Возвращает статус жизни человека.
     */
    public String getLifeStatus() {
        if (dod == null) {
            return "Alive";
        } else {
            return "Dead";
        }
    }

    /**
     * Печатает возраст человека и статус жизни.
     */
    public void PrintAge() {
        if (dod == null) {
            System.out.println(getLifeStatus() + ", age is: " + this.getAge());
        } else {
            System.out.println(getLifeStatus() + ", age was: " + this.getAge());
        }
    }

    /**
     * Возвращает строку с описанием человека.
     */
    @Override
    public String toString() {
        return getAbout();
    }

    /**
     * Возвращает строку с полной информацией о человеке.
     */
    public String getAbout() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append("\nName: ");
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
     * Проверяет равенство объектов.
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
