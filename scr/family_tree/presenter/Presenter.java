package family_tree.presenter;

import family_tree.model.human.SpouseStatus;
import family_tree.model.service.Service;
import family_tree.model.human.Gender;
import family_tree.view.View;

import java.time.LocalDate;

/**
 * Класс {@code Presenter} представляет собой контроллер для работы с данными семьи.
 */
public class Presenter {
    private View view;
    private Service service;

    /**
     * Конструктор для создания экземпляра {@code Presenter}.
     */
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    /**
     * Добавляет нового члена семьи.
     */
    public boolean addMember(String name, Gender gender, String date) {
        service.addMember(name, gender, date);
        return true;
    }

    /**
     * Устанавливает дату смерти для указанного члена семьи.
     */
    public boolean setDeathDate(int personId, LocalDate dod) {
        if (service.checkById(personId)) {
            service.setDeathDate(personId, dod);
            return true;
        }
        return false;
    }

    /**
     * Устанавливает родителя для указанного члена семьи.
     */
    public boolean setParent(int memberId, int parentId){
        if (service.checkById(memberId) & service.checkById(parentId)){
            service.setParent(memberId,parentId);
            return true;
        }
        return false;
    }

    /**
     * Устанавливает супруга для двух членов семьи.
     */
    public boolean setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        if (service.checkById(firstMemberId) & service.checkById(secondMemberId)) {
            service.setSpouse(firstMemberId, secondMemberId, spouseStatus);
            return true;
        }
        return false;
    }

    /**
     * Получает информацию о семье и отображает ее через представление.
     */
    public void getAboutFamily() {
        view.printAnswer(service.getAboutFamily());
    }

    /**
     * Сортирует семейное дерево по возрасту и отображает результат через представление.
     */
    public void sortTreeByAge() {
        view.printAnswer(service.sortTreeByAge());
    }

    /**
     * Сортирует семейное дерево по имени и отображает результат через представление.
     */
    public void sortTreeByName() {
        view.printAnswer(service.sortTreeByName());
    }

    /**
     * Считывает данные семьи из файла.
     */
    public boolean read(String path) {
        return service.read(path);
    }

    /**
     * Записывает данные семьи в файл.
     */
    public boolean write(String path) {
        return service.write(path);
    }
}
