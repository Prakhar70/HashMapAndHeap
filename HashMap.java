import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HashMap<K, V> {

    private class HMNode {
        K key;
        V value;

        HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private LinkedList<HMNode>[] buckets;

    HashMap() {
        this.size = 0;
        initBuckets(4);
    }

    private void initBuckets(int bSize) {
        buckets = new LinkedList[bSize];
        for (int i = 0; i < bSize; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int getIndexWithinBucket(LinkedList<HMNode> list,K key){
        for(int i=0;i<list.size();i++){
            if(key == list.get(i).key){
                return i;
            }
        }
        return -1;

    }
    public void put(K key, V value) {
        int bi = hashFn(key);
        LinkedList<HMNode> bucket = buckets[bi];
        int idx = getIndexWithinBucket(bucket, key);
        if(idx != -1){
            bucket.get(idx).value=value;
        }else{
            HMNode newNode = new HMNode(key,value);
            bucket.add(newNode);
            this.size++;
            double lambda = this.size*1.0 / this.buckets.length;
            if (lambda > 2.0) {
                rehash();
            }
        }
        
    }

    private void rehash() {

        LinkedList<HMNode>[] oldBuckets = this.buckets;
        initBuckets(2 * this.buckets.length);
        size = 0;
        for (LinkedList<HMNode> bucket:oldBuckets) {
            for(HMNode node: bucket){
                this.put(node.key, node.value);
            }
        }

    }

    private int hashFn(K key) {
        return (Math.abs(key.hashCode())) % this.buckets.length;
    }

    public V get(K key) {
        int bi = hashFn(key);
        LinkedList<HMNode> bucket = buckets[bi];
        int idx = getIndexWithinBucket(bucket, key);
        if(idx != -1){
            return bucket.get(idx).value;
        }
        return null;
    }

    public V remove(K key) {
        int bi = hashFn(key);
        LinkedList<HMNode> bucket = buckets[bi];
        int idx = getIndexWithinBucket(bucket, key);
        if(idx != -1){
            HMNode node = bucket.remove(idx);
            this.size--;
            return node.value;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int bi = hashFn(key);
        LinkedList<HMNode> bucket = buckets[bi];
        int idx = getIndexWithinBucket(bucket, key);
        if(idx != -1){
            return true;
        }
        return false;
    }
    public Set<K> keyset() throws Exception{
        Set<K> keys=new HashSet<>();
        for(LinkedList<HMNode> bucket:buckets){
            for(HMNode node: bucket){
                keys.add(node.key);
            }
        }
        return keys;
    }

    public int size() {
        return this.size;
    }

}
