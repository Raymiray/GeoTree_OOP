package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.SpouseStatus;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

//        Адреса файла для записи/чтения:
        String path1 = "src/ru/gb/family_tree/writer/family_tree_sorted_by_name.out";
        String path2 = "src/ru/gb/family_tree/writer/family_tree_sorted_by_age.out";

//        Инициализируем экземпляр класса для записи/чтения:
        FileHandler fileHandler = new FileHandler();

//        Инициализируем экземпляр класса семейного древа:
        FamilyTree familyTree = testTree();

        System.out.println("\nДанные из семейного древа ДО чтения из файла:\n");
        System.out.println(familyTree);

        System.out.println("---------");
        System.out.println("Sorted by Name:\n");

        familyTree.sortByName();
        System.out.println(familyTree);

//  ---------------------------------------
//        Запись в файл:
        fileHandler.write(familyTree, path1);

//  ------------------------------------

        System.out.println("Sorted by Age:\n");

        familyTree.sortByAge();
        System.out.println(familyTree);

//  ---------------------------------------
//        Запись в файл:
        fileHandler.write(familyTree, path2);

//  ------------------------------------

//  ------------------------------------

//        Чтение из файла:
        FamilyTree familyTreeRestored1 = (FamilyTree) fileHandler.read(path1);
        System.out.println("\nДанные из семейного древа c сортировкой по имени\nПОСЛЕ чтения из файла:\n");
        System.out.println(familyTreeRestored1);

//  ------------------------------------

//        Чтение из файла:
        FamilyTree familyTreeRestored2 = (FamilyTree) fileHandler.read(path2);
        System.out.println("\nДанные из семейного древа c сортировкой по возрасту\nПОСЛЕ чтения из файла:\n");
        System.out.println(familyTreeRestored2);
    }

//  ---------------------------------------------


    static FamilyTree testTree() {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human("Антонов Антон Антонович", Gender.male, LocalDate.of(1999, 1, 11));
        Human human2 = new Human("Антонова Антуанетта Антоновна", Gender.female, LocalDate.of(1999, 2, 12));
        Human human3 = new Human("Антонов Сеймур Сеймурович", Gender.male, LocalDate.of(1950, 3, 13));
        Human human4 = new Human("Антонова Аника Антоновна", Gender.female, LocalDate.of(1960, 4, 14));
        Human human5 = new Human("Никонов Мир Антонович", Gender.male, LocalDate.of(1960, 12, 1));
        Human human6 = new Human("Никонова Мира Антоновна", Gender.female, LocalDate.of(1960, 12, 2), LocalDate.of(2011, 1, 11));

        human1.setFather(human3);
        human1.setMother(human4);
        human2.setFather(human5);
        human2.setMother(human6);
        human3.addChild(human1);
        human4.addChild(human1);
        human1.addSpouse(human2, SpouseStatus.Actual);
        human2.addSpouse(human1, SpouseStatus.Actual);
        human3.addSpouse(human4, SpouseStatus.Actual);
        human4.addSpouse(human3, SpouseStatus.Actual);
        human5.addSpouse(human6, SpouseStatus.Actual);
        human6.addSpouse(human5, SpouseStatus.Actual);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);

        return familyTree;
    }
}
