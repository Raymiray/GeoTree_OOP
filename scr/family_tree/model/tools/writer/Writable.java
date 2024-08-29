package family_tree.model.tools.writer;

import java.io.Serializable;

/**
 * Интерфейс Writable определяет методы для записи и чтения объектов.
 */
public interface Writable {

    /**
     * Записывает сериализуемый объект в файл или другое хранилище по указанному пути.
     */
    boolean write(Serializable serializable, String path);

    /**
     * Читает объект из файла или другого хранилища по указанному пути.
     */
    Object read(String path);
}
