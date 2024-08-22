package ru.gb.family_tree.writer;

import java.io.Serializable;

/**
 * Интерфейс для записи и чтения объектов.
 */
public interface Writable {

    /**
     * Записывает сериализуемый объект в указанный путь.
     */
    boolean write(Serializable serializable, String path);

    /**
     * Читает объект из указанного пути.
     */
    Object read(String path);
}
