package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Q050_MaxFrequencyStack {
    HashMap<Integer,List<Integer>> countMap;
    HashMap<Integer,Integer> map;
    public Q050_MaxFrequencyStack() {
        countMap= new HashMap<>();
        map = new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val,0 )+1);
        if(countMap.containsKey(map.get(val))){
            countMap.get(map.get(val)).add(val);
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(val);
            countMap.put(map.get(val),list);
        }
    }
    
    public int pop() {
        int size = countMap.size();
        int rVal = countMap.get(size).removeLast();
        if(countMap.get(size).isEmpty()){
            countMap.remove(size);
        }
        map.put(rVal,map.getOrDefault(rVal,0)-1);
        if(map.get(rVal) == 0){
            map.remove(rVal);
        }
        return rVal;
    }
}