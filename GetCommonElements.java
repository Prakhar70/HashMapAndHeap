import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetCommonElements {
    public List<Integer> getCommonElements(int[] a1, int[] a2){
        List<Integer> ans=new ArrayList<>();
        Set<Integer> set1=new HashSet<>();

        for(int ele: a1){
            set1.add(ele);
        }
        for(int ele:a2){
            if(set1.contains(ele) == true){
                ans.add(ele);
                set1.remove(ele);
            }  
        }
        return ans;
    }
}
