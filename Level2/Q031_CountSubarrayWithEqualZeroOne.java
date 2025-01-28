package Level2;

import java.util.HashMap;

public class Q031_CountSubarrayWithEqualZeroOne {
    static int countSubarrWithEqualZeroAndOne(int arr[], int n){
        int cnt = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                sum+=-1;
            }else{
                sum+=1;
            }
            if(map.containsKey(sum)){
                cnt+=map.get(sum);
            }
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }
}
