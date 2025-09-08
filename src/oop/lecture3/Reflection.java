package oop.lecture3;

/*
interface A extends U {}
interface B {}
interface U {}
class C implements A {}
class D extends C implements B {}
*/

import oop.lecture3.reflection.D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Получить все интерфейсы класса, включая интерфейсы от классов-родителей.
 Не включать интерфейсы родительских интерфейсов.
 */
public class Reflection {
    public static void main(String[] args) {
        List<Class<?>> result = getAllInterfaces(D.class);
        result.forEach(res -> System.out.println(res.getName()));
    }

    /**
     * Метод по получению все интерфейсов класса
     * @param cls текущий класс
     * @return список интерфейсов
     */
    private static List<Class<?>> getAllInterfaces(Class<?> cls) {
        List<Class<?>> interfaces = new ArrayList<>();
        while (cls != Object.class) {
            interfaces.addAll(Arrays.asList(cls.getInterfaces()));
            cls = cls.getSuperclass();
        }
        return interfaces;
    }
}
