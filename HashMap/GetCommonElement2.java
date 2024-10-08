package HashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetCommonElement2 {
    public List<Integer> getCommonElements2(int[] a1, int[] a2) {

        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int ele : a1) {
            if (hmap.containsKey(ele)) {
                int of = hmap.get(ele);
                hmap.put(ele, of + 1);
            } else {
                hmap.put(ele, 1);
            }
        }
        for (int ele : a2) {
            if (hmap.containsKey(ele) && hmap.get(ele) > 0) {
                ans.add(ele);
                int val = hmap.get(ele);
                hmap.put(ele, val - 1);
            }
        }
        return ans;
    }
}
