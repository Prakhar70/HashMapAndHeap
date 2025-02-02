package Level2;

import java.util.HashMap;

public class Q036_RabbitsInForest {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int answer:answers){
            map.put(answer, map.getOrDefault(answer,0)+1);
        }
        int cnt = 0;
        for(int key:map.keySet()){
            int val =  map.get(key);
            cnt+=(val/(key+1))*(key+1);
            if(val%(key+1)!=0){
                cnt+=(key+1);
            }
        }
        return cnt;
    }
}
