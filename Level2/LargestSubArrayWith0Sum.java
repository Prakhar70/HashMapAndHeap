package Level2;

import java.util.HashMap;

public class LargestSubArrayWith0Sum {
    int maxLen(int arr[]) {
        int n= arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int runningSum = 0;
        int maxLen =0;
        for(int i=0;i<n;i++){
            runningSum+=arr[i];
            if(map.containsKey(runningSum)){
                maxLen = Math.max(maxLen, i-map.get(runningSum));
            }else{
                map.put(runningSum, i);
            }
        }
        return maxLen;

    }
}
