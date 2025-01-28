package Level2;

import java.util.HashMap;

public class Q028_LongestSubarrayWithSumDivisibleByK {
    int longestSubarrayDivK(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum =0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int key = sum%k;
            if(key<0){
                key+=k;
            }
            if(map.containsKey(key)){
                maxLen = Math.max(maxLen, i-map.get(key));
            }else{
                map.put(key,i);
            }
        }
        return maxLen;
    }
}
