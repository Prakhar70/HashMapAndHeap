package HashMap;

public class countSubArrayWithXorK {
    public int subarraysWithXorK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int cx=0,cnt = 0, px = 0;
        map.put(cx,1);
        for(int i=0;i<n;i++){

            cx = cx^nums[i];
            px = cx ^k;
            if(map.containsKey(px)){
                cnt+=map.get(px);
            }
            if(!map.containsKey(cx)){
                map.put(cx, 1);
            }else{
                int of = map.get(cx);
                map.put(cx,of+1);
            }
        }
        return cnt;
    }
}
