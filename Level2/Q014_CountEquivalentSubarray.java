package Level2;

import java.util.HashMap;
import java.util.HashSet;

public class Q014_CountEquivalentSubarray {
    int countDistinctSubarray(int arr[], int n) { 
        int noOfUniqueCharacters = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int ele:arr){
            set.add(ele);
        }
        noOfUniqueCharacters = set.size();
        int j = 0;
        int cnt=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            while (map.size() == noOfUniqueCharacters) {
                cnt+=(n-i);
                map.put(arr[j], map.get(arr[j])-1);
                if(map.get(arr[j])==0){
                    map.remove(arr[j]);
                }
                j++;
            }
        }
        return cnt;
    }
}
