package Level2;

import java.util.HashMap;

public class Q043_4Sum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int cnt =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                int sum = nums1[i]+nums2[j];
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = nums3[i]+nums4[j];
                if(map.containsKey(-sum)){
                    cnt+=map.get(-sum);
                }
            }
        }
        return cnt;
    }  
}
