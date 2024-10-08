package HashMap;

import java.util.HashSet;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int cnt=0;
        int runningSum = 0;
        for(int i=0;i<n;i++){
            runningSum+=nums[i];
            if(map.containsKey(runningSum-k)){
                int noe = map.get(runningSum-k);
                cnt+=noe;
            }
            if(map.containsKey(runningSum)){
                int noe=map.get(runningSum);
                map.put(runningSum,noe+1);
            }else{
                map.put(runningSum,1);
            }
       }
       return cnt;
    }
}