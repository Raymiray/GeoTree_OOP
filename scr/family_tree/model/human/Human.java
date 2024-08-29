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
 * Класс Human представляет человека и его информацию для семейного древа.
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
     * Конструктор для создания объекта Human.
     */
    public Human(String name, Gender gender, String dob) {
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.dob = LocalDate.parse(dob);
        this.dod = null;
        this.children = new ArrayList<>();
        this.mother = null;
        this.father = null;
        this.spouses = new HashMap<>();
    }

    /**
     * Возвращает уникальный идентификатор человека.
     */
    public long getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор человека.
     */
    public void setId(long id) {
        this.id = id;
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
     * Возвращает дату смерти человека.
     */
    public LocalDate getDod() {
        return dod;
    }

    /**
     * Устанавливает дату смерти человека.
     */
    public void setDod(LocalDate dod) {
        this.dod = dod;
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
     * Возвращает список детей человека.
     */
    public List<Human> getChildren() {
        return children;
    }

    /**
     * Добавляет ребенка к человеку.
     */
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    /**
     * Возвращает информацию о детях человека.
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
     * Возвращает информацию о матери человека.
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
     * Возвращает информацию об отце человека.
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
     * Возвращает список супругов человека и их статус.
     */
    public HashMap<Human, SpouseStatus> getSpouse() {
        return spouses;
    }

    /**
     * Добавляет супруга(-у) к человеку.
     */
    public void addSpouse(Human spouse, SpouseStatus status) {
        if (!this.spouses.containsKey(spouse)) {
            this.spouses.put(spouse, status);
            spouse.addSpouse(this, status);
        }
    }

    /**
     * Возвращает информацию о супругах человека.
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
     * Возвращает информацию о человеке.
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
     * Вычисляет интервал между двумя датами в годах.
     */
    private int getInterval(LocalDate dob, LocalDate dod) {
        Period interval = Period.between(dob, dod);
        return interval.getYears();
    }

    @Override
    public String toString() {
        return getAbout();
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
