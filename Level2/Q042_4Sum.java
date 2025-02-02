package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q042_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> mans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    List<Integer> ans=new ArrayList<>();
                    if(l<n-1 && nums[l]==nums[l+1]){
                        l--;
                        continue;
                    }
                    if(k>j+1 && nums[k]==nums[k-1]){
                        k++;
                        continue;
                    }
                    if((long)(nums[k]+nums[l]) > (target-(long)(nums[i]+nums[j]))){
                        l--;
                    }else if((long)(nums[k]+nums[l]) < (target-(long)(nums[i]+nums[j]))){
                        k++;
                    }else{
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        ans.add(nums[l]);
                        mans.add(ans);
                        k++;
                        l--;
                    }

                }
            }
        }
        return mans;
    }
}
