package Level2;

import java.util.HashMap;

public class Q046_FirstUniqueChar {
    public int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e:s.toCharArray()){
            map.put(e, map.getOrDefault(e, 0)+1);
        }
        for(int i=0;i<n;i++){
            int ele = s.charAt(i);
            if(map.get(ele)==1){
                return i;
            }
        }
        return -1;
    }
}
