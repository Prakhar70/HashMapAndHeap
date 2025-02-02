package Level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q040_TaskCompletion {
    List<List<Integer>> findTasks(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele:arr){
            set.add(ele);
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        boolean placeInA = true;
        for(int i=1;i<=k;i++){
            if(set.contains(i)){
                continue;
            }
            if(placeInA){
                a.add(i);
                placeInA = false;
            }else {
                b.add(i);
                placeInA = true;
            }
        }
        list.add(a);
        list.add(b);
        return list;
    }
}
