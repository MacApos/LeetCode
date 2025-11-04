package Arrays.General;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));

    }

   static public List<String> fizzBuzz(int n) {
       List<String> strings = new ArrayList<>(List.of());

       for (int i = 1; i <= n; i++) {
           if(i % 5 == 0 && i % 3 ==0){
               strings.add("FizzBuzz");
           } else if(i % 3 ==0){
               strings.add("Fizz");
           } else if(i % 5 ==0){
               strings.add("Buzz");
           } else {
               strings.add(Integer.toString(i));
           }
       }

       return strings;
    }
}
