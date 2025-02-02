package Level2;

import java.util.HashMap;
import java.util.List;

public class Q049_BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        int maxFreq = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(List<Integer> row:wall){
            int end =0;
            for(int i=0;i<row.size()-1;i++){
                end+=row.get(i);
                map.put(end,map.getOrDefault(end, 0)+1);
                maxFreq=Math.max(maxFreq,map.get(end));
            }
        }
        return wall.size() - maxFreq;
    }
}
