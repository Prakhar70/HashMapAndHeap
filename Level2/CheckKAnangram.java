package Level2;

import java.util.HashMap;
import java.util.HashSet;

public class CheckKAnangram {
    boolean areKAnagrams(String s1, String s2, int k) {
        if(s1.length() != s2.length()){
            return false;
        }
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        for(char ch:s1.toCharArray()){
            s1Map.put(ch, s1Map.getOrDefault(ch, 0)+1);
        }
        for(char ch:s2.toCharArray()){
            s2Map.put(ch, s2Map.getOrDefault(ch, 0)+1);
        }
        HashSet<Character> commonSet = new HashSet<>();
        for(Character ch: s1Map.keySet()){
            if(s2Map.containsKey(ch)){
                commonSet.add(ch);
            }
        }
        for(Character ch:commonSet){
            int freq1 = s1Map.get(ch);
            int freq2 = s2Map.get(ch);
            int minFreq = Math.min(freq1, freq2);
            s1Map.put(ch, s1Map.get(ch)-minFreq);
            s2Map.put(ch, s2Map.get(ch)-minFreq);
            if(s1Map.get(ch)==0){
                s1Map.remove(ch);
            }
            if(s2Map.get(ch)==0){
                s2Map.remove(ch);
            }
        }
        int cnt =0;
        for(Character ch:s1Map.keySet()){
            cnt+=s1Map.get(ch);
        }
        
        return Math.abs(cnt) <= k;
    }
}
