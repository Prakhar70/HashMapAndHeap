package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q021_AnagramMapping {
    static class Pair{
        List<Integer> ans;
        int idx;
        Pair(){
            ans = new ArrayList<>();
            idx = 0;
        }
        public int getAndUpdate(){
            return this.ans.get(this.idx++);
        }
        public void add(int ele){
            this.ans.add(ele);
        }
        
    }
    public static int[] anagramMapping(int n, int[] a, int[] b) {
        HashMap<Integer,Pair> map = new HashMap<>();
		for(int i=0;i<n;i++){
            if(map.containsKey(b[i])){
                map.get(b[i]).add(i);
            }else{
                Pair p = new Pair();
                p.add(i);
                map.put(b[i],p);
            }
        }
        int[] ans = new int[n];
        for (int i=0;i<n;i++){
            ans[i]=map.get(a[i]).getAndUpdate();
        }
        return ans;
	}
}
