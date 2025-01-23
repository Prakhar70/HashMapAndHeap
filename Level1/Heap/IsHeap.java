package Level1.Heap;

public class IsHeap {
    public boolean isHeap(int[] nums) {
        int n = nums.length;
        for(int i =0;i<nums.length; i++){
            int lci = 2*i+1;
            int rci = 2*i+2;
            if((lci < n && nums[lci]<nums[i]) || (rci < n && nums[rci]<nums[i])){
                return false;
            }
        }
        return true;
    }
}
