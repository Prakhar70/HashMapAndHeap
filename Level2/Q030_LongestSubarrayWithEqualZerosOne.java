package Level2;

import java.util.HashMap;

public class Q030_LongestSubarrayWithEqualZerosOne {
    public int maxLen(int[] arr) {
        int maxLen = 0;
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                sum+=-1;
            }else{
                sum+=1;
            }
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}
