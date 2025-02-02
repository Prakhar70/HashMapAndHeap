package Level2;
import java.util.HashMap;

public class Q038_ArithmeticSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int a =Integer.MAX_VALUE;
        int an = Integer.MIN_VALUE;
        for(int ele:arr){
            a= Math.min(a, ele);
            an = Math.max(an, ele);
        }
        int d = (an-a)/(n-1);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:arr){
            map.put(ele, map.getOrDefault(ele,0)+1);
        }
        int term = a;
        for(int i=0;i<n;i++){
            if(!map.containsKey(term)){
                return false;
            }
            map.put(term, map.get(term)-1);
            if(map.get(term)==0){
                map.remove(term);
            }
            term = term+d;
        }
        return true;
    }
}
