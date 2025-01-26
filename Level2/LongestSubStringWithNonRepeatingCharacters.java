package Level2;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithNonRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || n == 1){
            return n;
        }
        Character rc = null;
        int i = 0, j = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            while (i<n && rc == null) {
                
                if (set.contains(s.charAt(i)) == false) {
                    maxLen = Math.max(maxLen, i - j +1);
                    set.add(s.charAt(i));
                } else {
                    rc = s.charAt(i);
                }
                i++;
                flag1 = true;
            }
            while (j<n && rc != null) {
                if (s.charAt(j) != rc) {
                    set.remove(s.charAt(j));
                } else {
                    rc = null;
                }
                j++;
                flag2 = true;
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return maxLen;
    }
}
