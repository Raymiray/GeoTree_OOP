package family_tree.model.tools.writer;

import java.io.Serializable;

/**
 * Интерфейс для работы с объектами, поддерживающими запись и чтение данных.
 * <p>
 * Этот интерфейс определяет методы для записи и чтения данных из файлов.
 * </p>
 */
public interface Writable {

    /**
     * Записывает объект в файл по указанному пути.

     */
    boolean write(Serializable serializable, String path);

    /**
     * Читает объект из файла по указанному пути.
     */
    Object read(String path);
}
