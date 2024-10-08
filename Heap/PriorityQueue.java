package Heap;
import java.util.ArrayList;

public class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
        data = new ArrayList<Integer>();
    }
    // public PriorityQueue(int[] arr) {

    //     data = new ArrayList<Integer>();
    //     for(int ele:arr)
    //         this.add(ele);
    // }
    
    public PriorityQueue(int[] arr) {

        data = new ArrayList<Integer>();
        for(int ele:arr)
            this.data.add(ele);
        
        int n = data.size();
        for(int i=n/2 - 1; i>=0;i--){
            downheapify(i);
        }
    }

    public void add(int val) {
        this.data.add(val);
        upheapify(this.data.size() - 1);
    }

    private void upheapify(int ci) {
        if (ci == 0) {
            return;
        }
        int pi = ci - 1 / 2;
        if (this.data.get(ci) < this.data.get(pi)) {
            swap(pi, ci);
            upheapify(pi);
        }

    }

    private void swap(int i, int j) {
        int temp = this.data.get(i);
        this.data.set(i, this.data.get(j));
        this.data.set(j, temp);

    }

    public int remove() {
        if(size() == 0){
            System.out.println("Underflow");
            return -1;
        }
        swap(0, size() - 1);
        int val = data.remove(this.size()-1);
        downheapify(0);
        return val;
    }

    private void downheapify(int pi) {
        int mini = pi;
        int lci = pi*2+1;
        int rci = pi*2+2;
        if(lci<size()-1 && this.data.get(lci)<this.data.get(mini)){
            mini = lci;
        }
        if(rci<size()-1 && this.data.get(rci)<this.data.get(mini)){
            mini = rci;
        }
        if (mini != pi){
            swap(mini, pi);
            downheapify(mini);
        }
    }

    public int peek() {
        if (size() != 0) {
            System.out.println("No Element present");
            return -1;
        }
        return this.data.get(0);
    }

    public int size() {
        return this.data.size();
    }
}
