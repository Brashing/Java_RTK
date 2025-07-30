/*Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
123456 Иванов
321456 Васильев
234561 Петрова
234432 Иванов
654321 Петрова
345678 Иванов
Вывести данные по сотрудникам с фамилией Иванов.*/

package Java_RTK;

import java.util.HashMap;
import java.util.Map;

public class Example6 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("123456", "Иванов");
        map.put("321456", "Васильев");
        map.put("234561", "Петрова");
        map.put("234432", "Иванов");
        map.put("654321", "Петрова");
        map.put("345678", "Иванов");
        String name = "Иванов";
        for(Map.Entry<String,String> entry : map.entrySet()) {
            String passportNumber = entry.getKey();
            String passportName = entry.getValue();
            if (!name.equals(passportName)) {
//                System.out.println("%s->%d", entry.getKey(),entry.getValue());
            }
        }
    }
}