package Level1.Heap;

import java.util.PriorityQueue;

class KthLargestStream {

    PriorityQueue<Integer> pq;
    int k;
    public KthLargestStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int i = 0;i<nums.length; i++){
            if(pq.size() < k){
                pq.add(nums[i]);
            }else{
                if(nums[i]>pq.peek()){
                    pq.remove();
                    pq.add(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < k){
                pq.add(val);
        }else{
            if(val>pq.peek()){
                pq.remove();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}