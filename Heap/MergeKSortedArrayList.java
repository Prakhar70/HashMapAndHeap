package Heap;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrayList {
    static class Pair {
        int listIdx;
        int eleIdx;
        int ele;

        Pair(int listIdx, int eleIdx, int ele) {
            this.listIdx = listIdx;
            this.eleIdx = eleIdx;
            this.ele = ele;
        }
        public int compareTo(Pair o){
            return this.ele - o.ele;
        }
    }

    public static ArrayList<Integer> mergeSortedLists(ArrayList<ArrayList<Integer>> lists) {
        int k = lists.size();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(i, 0, lists.get(i).get(0)));
        }
        while (!pq.isEmpty()) {
            Pair rPair = pq.remove();
            ans.add(rPair.ele);
            rPair.eleIdx++;
            if (lists.get(rPair.listIdx).size() > rPair.eleIdx)
                rPair.ele = lists.get(rPair.listIdx).get(rPair.eleIdx);
        }
        return ans;
    }
}
