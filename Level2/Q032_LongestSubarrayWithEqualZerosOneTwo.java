package Level2;

import java.util.HashMap;

public class Q032_LongestSubarrayWithEqualZerosOneTwo {
    public static int maxSubarrays(int n, int[] arr) {
		HashMap<String,Integer> map = new HashMap<>();
        int one = 0;
        int two = 0;
        int zero = 0;
        int maxLen = 0;
        map.put("0#0",-1);
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                zero++;
            }else if(arr[i]==1){
                one++;
            }else{
                two++;
            }
            String KeyStr = (one-zero)+"#"+(two-one);
            if(map.containsKey(KeyStr)){
                maxLen = Math.max(maxLen,i-map.get(KeyStr));
            }else{
                map.put(KeyStr, i);
            }
        }
        return maxLen;
    }
        
}
