package Heap;
import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    public MedianFinder() {
        pq1 = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq2 = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(pq1.isEmpty() && pq2.isEmpty()){
            pq1.add(num);
            return;
        }
        if(num<=pq1.peek()){
            pq1.add(num);
        }else{
            pq2.add(num);
        }
        if(pq1.size()>pq2.size()+1){
            pq2.add(pq1.remove());
        }else if(pq2.size()>pq1.size()){
            pq1.add(pq2.remove());
        }

    }

    public double findMedian() {
        int size= pq1.size()+pq2.size();
        
        double ans=0;
        if(size%2==0){
            ans = (pq1.peek()+pq2.peek())/2.0;
        }
        if(size%2==1){
            ans = pq1.peek();
        }
        return ans;
    }   
}