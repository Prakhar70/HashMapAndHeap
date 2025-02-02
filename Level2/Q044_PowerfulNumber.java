package Level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q044_PowerfulNumber {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=1;i<bound;i*=x){
            for(int j=1;j<bound;j*=y){
                if(i+j>bound){
                    break;
                }
                set.add(i+j);
                if(y==1){
                    break;
                }
            }
            if(x == 1){
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }
}
