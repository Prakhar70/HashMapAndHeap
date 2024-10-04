import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargest {
    public List<Integer> KLargest(int[] nums,  int k ){
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(pq.size()<k){
                pq.add(nums[i]);
                continue;
            }
            if(pq.peek()<nums[i]){
                pq.remove(pq.peek());
                pq.add(nums[i]);
            }
        }
        while(pq.isEmpty()){
            ans.add(pq.remove());
        }
        return ans;
    }
}
