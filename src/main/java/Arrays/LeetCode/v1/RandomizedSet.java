package Arrays.LeetCode.v1;

import java.util.*;

public class RandomizedSet {
    public Random random;
    public ArrayList<Integer> randomizedSet;
    public HashMap<Integer, Integer> hashMap;

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(2);
        boolean param_3 = obj.insert(2);
        int param_4 = obj.getRandom();
        boolean param_5 = obj.remove(1);
        boolean param_6 = obj.insert(2);
        int param_7 = obj.getRandom();

        for (Object o : new ArrayList<Object>(List.of(param_1, param_2, param_3, param_4, param_5, param_6, param_7))) {
            System.out.println(o);
        }
    }


    public RandomizedSet() {
        random = new Random();
        randomizedSet = new ArrayList<>();
        hashMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (hashMap.containsKey(val)) {
            return false;
        }
        hashMap.put(val, hashMap.size());
        randomizedSet.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) {
            return false;
        }

        Integer key = hashMap.get(val);
        Integer lastElement = randomizedSet.get(randomizedSet.size() - 1);
        randomizedSet.set(key, lastElement);
        randomizedSet.remove(randomizedSet.size() - 1);
        hashMap.put(lastElement, key);
        hashMap.remove(val);
        return true;
    }

    public int getRandom() {
        return randomizedSet.get(random.nextInt(0, randomizedSet.size()));
    }
}
