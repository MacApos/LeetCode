package ChatGPTPropositions.v1;

import java.util.ArrayList;

public class HappyNumbersFactory {
    public static void main(String[] args) {
        factory(99, 4);

    }

    public static void factory(int number, int repeat) {

        for (int i = 0; i < repeat; i++) {
            ArrayList<Integer> numbers = new ArrayList<>();

            double round = Math.floor(Math.log10(number));
            while (round >= 0) {
                int pow = (int) Math.pow(10, round);
                numbers.add((number / pow));
                number = (number % pow);
                round--;
            }
            number = 0;
            for (Integer integer : numbers) {
                number += (int) Math.pow(integer, 2);
            }
            System.out.println(number);

        }
    }
}
