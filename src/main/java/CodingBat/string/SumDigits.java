package CodingBat.string;

import java.util.*;
import java.util.stream.Collectors;

public class SumDigits {
    public static void main(String[] args) {
        int length = 50000000;
        List<Character> characters = new ArrayList<>(length);
        Random random = new Random();
        for (int i = 0; i < length / 2; i++) {
            characters.add(i, (char) (48 + random.nextInt(0, 10)));
        }

        char start = 'A';
        for (int i = 0; i < length / 2; i++) {
            characters.add(length / 2 + i, start++);
            if (start > 'z') {
                start = 'A';
            }
        }
        Collections.shuffle(characters);
        String collect = characters.stream().parallel().map(String::valueOf).collect(Collectors.joining());

        long t1 = System.currentTimeMillis();
        int sumDigits = sumDigits(collect);
        System.out.println(sumDigits);
        System.out.println(System.currentTimeMillis() - t1);
    }

    public static int sumDigits(String str) {
        return str.chars().parallel()
                .mapToObj(c -> (char) c)
                .filter(Character::isDigit)
                .map(c -> Integer.parseInt(String.valueOf(c)))
                .reduce(0, Integer::sum);
    }
}
