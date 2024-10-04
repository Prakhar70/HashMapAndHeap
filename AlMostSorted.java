import java.util.ArrayList;
import java.util.PriorityQueue;

public class AlMostSorted {
    ArrayList<Integer> nearlySorted(int arr[], int num, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        ArrayList<Integer> ans= new ArrayList<Integer>();
        for(int i=0;i<num;i++){
            if(pq.size()<=k+1){
                pq.add(arr[i]);
            }
            else{
                int removedEle = pq.remove();
                pq.add(arr[i]);
                ans.add(removedEle);
            }
        }
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        return ans;
    }
}
