package Level2;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctWindow {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int i=0,j=0;
        for(;j<k-1;j++){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
        }
        for(j=k-1;j<n;j++){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            ans.add(map.size());
            map.put(arr[i],map.get(arr[i])-1);
            if(map.get(arr[i])==0){
                map.remove(arr[i]);
            }
            i++;
        }
        return ans;
    }
}
