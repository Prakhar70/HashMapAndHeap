package Level1.Heap;

public class Min2MaxHeap {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        for (int pi = n / 2 - 1; pi >= 0; pi--) {
            downheapify(nums, pi);
        }
        return nums;
    }

    private void downheapify(int[] nums, int pi) {
        int n = nums.length;
        int maxi = pi;
        int lci = pi * 2 + 1;
        int rci = pi * 2 + 2;
        if (lci < n && nums[lci] > nums[maxi]) {
            maxi = lci;
        }
        if (rci < n && nums[rci] > nums[maxi]) {
            maxi = rci;
        }
        if (maxi != pi) {
            swap(nums, pi, maxi);
            downheapify(nums, maxi);
        }
    }

    private void swap(int[] nums, int pi, int maxi) {
        int temp = nums[pi];
        nums[pi] = nums[maxi];
        nums[maxi] = temp;
    }
}
