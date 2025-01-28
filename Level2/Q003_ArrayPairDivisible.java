package Level2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q003_ArrayPairDivisible {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scn.nextInt());
        }
        int k = scn.nextInt();
        boolean isDivisible = CheckIfPairDivisible(list, k);
        System.out.println(isDivisible);
    }

    public static boolean CheckIfPairDivisible(List<Integer> list, int k) {
        if (k == 1) {
            return true;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : list) {
            int key = 0;
            if (ele >= 0) {
                key = ele % k;
            } else {
                key = k + (ele % k);
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (key == 0) {
                continue;
            }
            if (k % 2 == 0 && key == k / 2) {
                if (map.get(key) % 2 != 0) {
                    return false;
                } else {
                    continue;
                }
            }
            int freqOfKey = map.get(key);
            if (!map.containsKey(k - key)) {
                return false;
            }
            int freqOfKMinusKey = map.get(k - key);

            if (freqOfKMinusKey != freqOfKey) {
                return false;
            }
        }
        return true;
    }
}
