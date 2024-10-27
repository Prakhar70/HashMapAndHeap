package HashMap;
import java.util.HashMap;

class LongestConsecutive {
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
    public int longestConsecutive2(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int ele:nums){
            map.put(ele, true);
        }
        for(int ele:nums){
            if (map.containsKey(ele-1)){
                map.put(ele, false);
            }
        }
        int mLen =0;// will store the max len
        int tsi = 0;// will store the starting point from where the longest consecutive ss is present;
        for(int ele:nums){
            if(map.get(ele)==true){
                int len=1;
                while(map.get(ele+len)){
                    len++;
                }
                if(len>mLen){
                    tsi = ele;
                    mLen=len;
                }
            }
        }
        return mLen;
    }


}