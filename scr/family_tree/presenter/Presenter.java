package family_tree.presenter;

import family_tree.model.human.SpouseStatus;
import family_tree.model.service.Service;
import family_tree.model.human.Gender;
import family_tree.view.View;

import java.time.LocalDate;


public class Presenter {
    private View view;
    private Service service;

    /**
     * Конструктор класса Presenter.
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
     * Устанавливает дату смерти для члена семьи по его идентификатору.
     */
    public boolean setDeathDate(int personId, LocalDate dod) {
        if (service.checkById(personId)) {
            service.setDeathDate(personId, dod);
            return true;
        }
        return false;
    }

    /**
     * Устанавливает родителя для члена семьи по его идентификатору.
     */
    public boolean setParent(int memberId, int parentId){
        if (service.checkById(memberId) & service.checkById(parentId)){
            service.setParent(memberId, parentId);
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
     * Получает информацию о всей семье и передает её в представление.
     */
    public void getAboutFamily() {
        view.printAnswer(service.getAboutFamily());
    }

    /**
     * Сортирует членов семьи по возрасту и передает отсортированный список в представление.
     */
    public void sortTreeByAge() {
        view.printAnswer(service.sortTreeByAge());
    }

    /**
     * Сортирует членов семьи по имени и передает отсортированный список в представление.
     */
    public void sortTreeByName() {
        view.printAnswer(service.sortTreeByName());
    }

    /**
     * Считывает данные из файла и обновляет состояние сервиса.
     */
    public boolean read(String path) {
        return service.read(path);
    }

    /**
     * Записывает данные в файл.
     */
    public boolean write(String path) {
        return service.write(path);
    }
}
