package Level2;

import java.util.HashMap;

public class Q029_CountSubarrayWithSumDivisibleByK{
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int cnt=0;
        int sum=0;
        for(int ele:nums){
            sum+=ele;
            int rem = sum%k;
            if(rem<0){
                rem+=k;
            }
            if(map.containsKey(rem)){
                cnt+=map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return cnt;
    }
}