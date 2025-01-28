package Level2;

import java.util.HashMap;
import java.util.HashSet;

public class Q025_IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> mappedChars = new HashSet<>();
        for(int i = 0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else{
                if(mappedChars.contains(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
                mappedChars.add(t.charAt(i));
            }
        }
        return true;
    }
}
