package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KSorted {
    ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            if (pq.size() <= k) {
                pq.add(arr[i]);
            } else {
                int smallestElem = pq.remove();
                pq.add(arr[i]);
                ans.add(smallestElem);
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.remove());
        }
        return ans;
    }
}
