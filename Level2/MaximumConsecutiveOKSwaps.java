package Level2;

public class MaximumConsecutiveOKSwaps {
    public static int longestOnes(int[] nums, int K) {
        int n = nums.length;
        int k =0;
        int maxLen = 0;
        int j = 0;
        for(int i =0;i<n;i++){
            if(nums[i] == 0){
                k++;
            }
            if(k<=K){
                maxLen = Math.max(maxLen, i-j+1);
            }
            while(k>K){
                if(nums[j]==0){
                    k--;
                }
                j++;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums={1,1,0,1,0,0,1,1,0,1,0,1,1,1};
        System.out.println(longestOnes(nums, 1));
    }
        
}
