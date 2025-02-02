package Level2;

import java.util.Collection;
import java.util.HashMap;


public class Q048_XofAKind {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:deck){
            map.put(ele, map.getOrDefault(ele,0)+1);
        }
        int gcd = 0;
        for(int key:map.keySet()){
            gcd=gcd(gcd,map.get(key));
        }
        return gcd!=1;
    }
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        
        return gcd(b,a%b);
    }
}
