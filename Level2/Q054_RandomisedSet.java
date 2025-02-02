package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Q054_RandomisedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random random;

    public Q054_RandomisedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;

    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int rIdx = map.get(val);
        // swap rIdx with last element
        int temp = list.get(rIdx);
        list.set(rIdx,list.get(list.size()-1));
        list.set(list.size()-1,temp);
        list.removeLast();
        map.remove(val);
        if(rIdx != list.size())
            map.put(list.get(rIdx),rIdx);
        return true;
    }  
    
    public int getRandom() {
        // need correction
        int randomNumber = random.nextInt(list.size());
        return list.get(randomNumber);
    }
}
