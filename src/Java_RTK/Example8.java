/*Написать метод, который переведет число из римского формата записи в арабский.
Например, MMXXII = 2022*/

package Java_RTK;

import java.util.HashMap;
import java.util.Map;

//IX->1<10 о 10-1=9
//XIII->10+1+1+1=13

public class Example8 {
    public static int romanToArabic(String roman) {
        Map<Character,Integer> romanMap= new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        int result=0;
        int length=roman.length();

        for(int i=0;i<length-1;i++) {
            char currentChar=roman.charAt(i);
            char nextChar=roman.charAt(i+1);

            int currentVal=romanMap.get(currentChar);
            int nextVal=romanMap.get(nextChar);

            if(currentVal<nextVal){
                result-=currentVal;
            } else {
                result+=currentVal;
            }
        }

        result+=romanMap.get(roman.charAt(length-1));

        return result;
    }
    public static void main(String[] args) {
        String[] examples={
                "MMXXII",
                "IV",
                "IX",
                "XL",
                "XCIX",
                "MCMXCIV"
        };

        for (String roman : examples) {
            int arabic=romanToArabic(roman);
            System.out.printf("%s->%d%n",roman,arabic);
        }
    }
}
