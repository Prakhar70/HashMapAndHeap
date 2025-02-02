package Level2;

import java.util.HashMap;

public class Q033_CountSubarrayWithEqualZerosOneTwo {
    public static int countSubarrays(int n, int[] arr) {
		HashMap<String,Integer> map = new HashMap<>();
        int one = 0;
        int two = 0;
        int zero = 0;
        int cnt=0;
        map.put("0#0",1);
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
                cnt+= map.get(KeyStr);
            }
            map.put(KeyStr, map.getOrDefault(KeyStr,0)+1);
        }
        return cnt;
    }
}
