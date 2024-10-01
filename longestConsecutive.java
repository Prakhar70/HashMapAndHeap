import java.util.HashMap;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:nums){
            map.put(ele,1);
        }
        int mLen = 0;
        for(int i=0;i<n;i++){
            int key = nums[i];
            Integer val = map.get(key);
            if(val == null){
                continue;
            }
            while(map.containsKey(key+val)){
                map.put(key,val+map.get(key+val));
                map.remove(key+val);
                val = map.get(key);  
            }
            if(val > mLen){
                mLen= val;
            }
            
        }
        return mLen;
    }
    
}