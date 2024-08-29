package family_tree.model.tools.writer;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.family_tree.FamilyTreeElement;

import java.io.*;

/**
 * Класс FileHandler предоставляет методы для записи и чтения объектов FamilyTree в/из файлов.
 */
public class FileHandler<E extends FamilyTreeElement<E>> implements Writable {

    /**
     * Записывает сериализуемый объект в файл по указанному пути.
     */
    @Override
    public boolean write(Serializable serializable, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Читает объект FamilyTree из файла по указанному пути.
     */
    @Override
    public FamilyTree<E> read(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            FamilyTree<E> treeRead = (FamilyTree<E>) objectInputStream.readObject();
            return treeRead;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
