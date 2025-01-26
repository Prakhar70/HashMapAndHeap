package Level2;

import java.util.HashMap;
import java.util.HashSet;

public class LargestSubArrayWithContinousElement {
    public int maxLen(int arr[]) {
        int n = arr.length;
        int maxLen = 1;
        
        for(int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);
            int max = arr[i];
            int min = arr[i];
            for(int j=i+1;j<n;j++){
                if(set.contains(arr[j])){
                    break;
                }
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
                if(j-i == max-min){
                    maxLen = Math.max(maxLen, j-i+1);
                }
                set.add(arr[j]);
            }
        }
        return maxLen;

    }
}
