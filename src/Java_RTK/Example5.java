package Java_RTK;

import java.util.HashMap;
import java.util.Map;

public class Example5 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Яблоко",3);
        map.put("Банан",5);
        map.put("Помидор",2);
        int count=map.get("Банан");
        System.out.println(count);
        map.put("Яблоко",10);
        map.remove("Банан");
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.printf("%s->%d%n", entry.getKey(),entry.getValue());
        }
    }
}
