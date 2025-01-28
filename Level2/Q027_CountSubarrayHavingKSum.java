package Level2;
import java.util.HashMap;

public class Q027_CountSubarrayHavingKSum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int cnt =0;
        for(int ele:nums){
            sum+=ele;
            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }
}
