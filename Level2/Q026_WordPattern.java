package Level2;

import java.util.HashMap;
import java.util.HashSet;

public class Q026_WordPattern {
    public boolean wordPattern(String s, String t) {
        String[] strs = t.split(" ");
        if(strs.length != s.length()){
            return false;
        }
        int n = s.length();
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> mappedStrs = new HashSet<>();
        for(int i = 0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                if(!map.get(s.charAt(i)).equals(strs[i])){
                    return false;
                }
            }else{
                if(mappedStrs.contains(strs[i])){
                    return false;
                }
                map.put(s.charAt(i),strs[i]);
                mappedStrs.add(strs[i]);
            }
        }
        return true;
    }
}
