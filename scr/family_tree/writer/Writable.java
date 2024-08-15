package ru.gb.family_tree.writer;

import java.io.Serializable;

/**
 * Интерфейс Writable определяет методы для записи и чтения объектов.
 */
public interface Writable {
    boolean write(Serializable serializable, String path);
    Object read(String path);
}
