package ru.job4j.list;

import java.util.List;

/**
 * Может возникнуть ситуация, когда нам надо удалить элементы,
 * которые удовлетворяют какому-то условию. Чтобы не писать цикл,
 * в котором будет проверяться условие, в интерфейсе
 * Collection(наследником которого является интерфейс List)
 * определен метод removeIf():
 * <p>
 * default boolean removeIf​(Predicate filter) -
 * метод удаляет все элементы из коллекции, которые
 * удовлетворяют условию определенному в предикате
 * filter(передается в виде лямбда выражения).
 * Если в результате работы метода список изменился - метод возвращает true.
 * <p>
 * Задание: необходимо реализовать метод, который
 * вернет список строк, которые состоят из 5 и более символов.
 */
public class RemoveIf {
    public static List<String> sortList(List<String> list) {
        list.removeIf(n -> (n.length() < 5));

        return list;
    }
}
