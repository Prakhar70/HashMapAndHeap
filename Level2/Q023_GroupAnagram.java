package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q023_GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> freqMap = prepareFrequencyMap(str);
            ArrayList<String> list = map.getOrDefault(freqMap, new ArrayList<String>());
            list.add(str);
            map.put(freqMap, list);
        }
        for(HashMap<Character, Integer> key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }

    private HashMap<Character, Integer> prepareFrequencyMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch :str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        return map;
    }
}
