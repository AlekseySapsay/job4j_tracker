package ru.job4j.list;

import java.util.List;

/**
 * Ответим на 2 вопроса:
 * <p>
 * 1. Есть два списка, первый из них нужно полностью добавить в другой. Как это сделать?
 * <p>
 * 2. Необходимо удалить элемент из списка, однако мне неизвестен его индекс. Как это сделать?
 * <p>
 * Для того, чтобы добавить одну коллекцию в другую можно использовать метод addAll():
 * <p>
 * boolean addAll​(Collection<? extends E> c) - метод добавляет коллекцию с (в нашем случае - список) в список, на котором мы вызываем этот метод. Стоит упомянуть что так можно добавить все типы коллекций, которые наследуются от интерфейса Collection.
 * <p>
 * Для того чтобы удалить объект из списка, не зная его индекс используется метод remove() в следующем виде:
 * <p>
 * boolean remove(E e) - удаляет элемент е типа E из коллекции при его ПЕРВОМ вхождении в список, если он есть в коллекции.
 * <p>
 * ВАЖНО! Метод remove(E e) реализован с помощью цикла for(), подразумевает под собой первоначальный поиск удаляемого элемента и только потом он удаляется. Соответственно, использование этого метода внутри цикла, который перебирает список, не рекомендуется, поскольку мы будем проходить по списку дважды.
 * <p>
 * Задание: метод принимает 2 списка и элемент, который возможно содержится в этих списках. Вам необходимо проверить оба списка, содержат ли они одновременно этот элемент, если содержит - необходимо удалить элемент из первого списка. Потом второй список нужно добавить в первый. Метод должен вернуть индекс элемента, который пришел в параметрах метода из общего списка.
 */


public class AddAllElementsList {
    public static int containsElement(List<String> left, List<String> right, String str) {
        // if element contains in left and right list, then remove element from left
        int indexLeft = left.indexOf(str);
        int indexRight = right.indexOf(str);
        int indexTotal = 0;

        if (indexLeft == indexRight) {
            left.remove(indexLeft);
            left.addAll(right);
            indexTotal = left.indexOf(str);
            return indexTotal;
        } else {
            left.addAll(right);
            indexTotal = left.indexOf(str);
            return indexTotal;
        }
    }
}