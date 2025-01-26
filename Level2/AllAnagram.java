package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        int n = s.length();
        int m = p.length();
        if (s.length() < p.length()) return ans;

        for(int i=0;i<m;i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i),0)+1);
        }
        int j=0;
        for(int i=0;i<n;i++){
            if(i<m){
                sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
                if(i==m-1){
                    if(isValidAnagram(pMap, sMap)){
                        ans.add(0);
                    }
                }
                continue;
            }
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
            sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j),0)-1);
            if(sMap.get(s.charAt(j))==0){
                sMap.remove(s.charAt(j));
            }
            if(isValidAnagram(pMap, sMap)){
                ans.add(i-m+1);
            }
            j++;
        }
        return ans;
    }
    public static boolean isValidAnagram(HashMap<Character, Integer> sMap, HashMap<Character, Integer> pMap){
        if(sMap.keySet().size() != pMap.keySet().size()){
            return false;
        }
        for(char key:sMap.keySet()){
            if(pMap.get(key).equals(sMap.get(key))){
                return false;
            }
        }
        return true;
    }
}
