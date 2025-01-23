package Level1.HashMap;

class LongestSubArrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        hmap.put(0,-1);
        int maxLen=0;
        int runningSum =0;
        for(int i=0;i<n;i++){
            runningSum+=nums[i];
            if(hmap.containsKey(runningSum-k)){
                int previousIdx = hmap.get(runningSum-k);
                maxLen=Math.max(maxLen, i-previousIdx);
            }
            if(!hmap.containsKey(runningSum)){
                hmap.put(runningSum,i);
            }
       }
       return maxLen;
    }
}