package Heap;

import java.util.*;
import java.util.PriorityQueue;
import java.lang.*;
import java.math.*;
import java.io.*;

// } Driver Code Ends

// User function Template for Java

public class GFG {
    static class Pair {
        int idx1;
        int idx2;

        Pair(int idx1, int idx2) {
            this.idx1 = idx1;
            this.idx2 = idx2;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (!(obj instanceof Pair))
                return false;
            Pair other = (Pair) obj;
            return idx1 == other.idx1 && idx2 == other.idx2;
        }

        @Override
        public int hashCode() {
            int result = Integer.hashCode(idx1);
            result = 31 * result + Integer.hashCode(idx2);
            return result;
        }

        @Override
        public String toString() {
            return idx1 + "-" + idx2;
        }
    }

    static class Triplet {
        int idx1;
        int idx2;
        int val;

        Triplet(int idx1, int idx2, int val) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.val = val;
        }

        @Override
        public String toString() {
            return idx1 + "-" + idx2 + "@" + val;
        }
    }

    public static void reverse(int[] arr) {
        int si = 0;
        int ei = arr.length - 1;
        while (si < ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;
            si++;
            ei--;
        }
    }

    static List<Integer> maxCombinations(int k, int nums1[], int nums2[]) {
        // code here
        int[] ans = new int[k];
        List<Integer> list = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        Arrays.sort(nums1);
        reverse(nums1);
        Arrays.sort(nums2);
        reverse(nums2);
        for (int i = 0; i < n; i++) {
            System.out.print(nums1[i] + "&");
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums2[i] + "--");
        }
        System.out.println();
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        Set<Pair> set = new HashSet<>();
        pq.add(new Triplet(0, 0, (n >= 1 ? nums1[0] : 0) + (m >= 1 ? nums2[0] : 0)));
        set.add(new Pair(0, 0));
        int idx = 0;
        while (idx < k) {
            System.out.println("set--" + set);
            System.out.println("pq---" + pq);
            Triplet trip = pq.remove();
            set.remove(new Pair(trip.idx1, trip.idx2));
            // ans[idx++] = trip.val;
            list.add(trip.val);
            idx++;
            Pair p1 = new Pair(trip.idx1 + 1, trip.idx2);

            if (set.isEmpty() || !set.contains(p1)) {

                Triplet pushElem = new Triplet(trip.idx1 + 1, trip.idx2,
                        ((trip.idx1 + 1) < n ? nums1[trip.idx1 + 1] : 0) + ((trip.idx2 < m) ? nums2[trip.idx2] : 0));

                pq.add(pushElem);
                set.add(p1);
            }
            Pair p2 = new Pair(trip.idx1, trip.idx2 + 1);
            if (set.isEmpty() || !set.contains(p2)) {
                Triplet pushElem = new Triplet(trip.idx1, trip.idx2 + 1,
                        ((trip.idx1 < n ? nums1[trip.idx1] : 0) + ((trip.idx2 + 1) < m ? nums2[trip.idx2 + 1] : 0)));
                pq.add(pushElem);
                set.add(p2);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // {371, 349, 552, 343, 331, 721, 46, 572, 512, 469, 890, 608 ,917, 719, 830, 104, 159};
        // {681, 150, 595, 597, 209, 778, 666, 965, 203, 658, 273, 404, 389, 898, 847, 253, 959};

        int[] nums1 = {355 ,996 ,662 ,84 ,637 ,927 ,189 ,55 ,189 ,530 ,152 ,1 ,902 ,374 ,944 ,551 ,469 ,956 ,50 ,124 ,944 ,488};
        int[] nums2 = {122 ,102 ,379 ,853 ,615 ,819 ,965 ,766 ,199 ,376 ,185 ,119 ,163 ,917 ,856 ,14 ,918 ,873 ,980 ,216 ,391 ,462;
        //1976 1961 1936 1924 1924 1921 1914 1913 1909 1909 1907 1892 1882 1874 1873

        System.out.println(maxCombinations(15, nums2, nums1));
    }
    
}
