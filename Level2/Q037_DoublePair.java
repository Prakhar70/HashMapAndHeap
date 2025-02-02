package Level2;
import java.util.Arrays;
import java.util.HashMap;


public class Q037_DoublePair {
    public boolean canReorderDoubled(int[] arr) {
        Integer[] ar = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            ar[i]=arr[i];
        }
        Arrays.sort(ar,(a,b)->{return Math.abs(b)-Math.abs(a);});
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:ar){
            if(map.containsKey(2*ele)){
                map.put(2*ele, map.get(2*ele)-1);
                if(map.get(2*ele)==0){
                    map.remove(2*ele);
                }
            }else{
                map.put(ele, map.getOrDefault(ele,0)+1);
            }
        }
        return map.isEmpty();
    }
}