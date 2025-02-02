package Level2;

import java.util.HashSet;

public class Q034_PairEqualSum {
    public boolean isEqualSumPair(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (set.contains(sum)) {
                    return true;
                }
                set.add(sum);
            }
        }
        return false;
    }
}
