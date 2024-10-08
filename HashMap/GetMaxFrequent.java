package HashMap;
import java.util.HashMap;

class GetMaxFrequent{
    public char getMaxFrequent(String s){
        
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c:s.toCharArray()){
            if(hm.containsKey(c)){
                int val = hm.get(c);
                hm.put(c, val+1);
            }
            else{
                hm.put(c, 1);
            }
        }
        int max = hm.get(s.charAt(0));
        char ans= s.charAt(0);
        for(Character key : hm.keySet()){
            if(hm.get(key) > max){
                max = hm.get(key);
                ans = key;
            }
        }
        return ans;

    }
}