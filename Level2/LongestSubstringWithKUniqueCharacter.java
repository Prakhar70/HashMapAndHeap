package Level2;

import java.util.HashMap;


public class LongestSubstringWithKUniqueCharacter {
    public static int LongestSubString(String str, int k){
        int i=0,j=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLen = -1;
        int n = str.length();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            while(j<n && map.size()<=k){
                
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j),0)+1);
                if(map.size() == k){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                j++;
                flag1 = true;
            }
            while(map.size()>k){
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)-1);
                if(map.get(str.charAt(i))==0){
                    map.remove(str.charAt(i));
                }
                i++;
                flag2 = true;
            }
            if(flag1 == false && flag2 == false){
                break;
            }
    
        }
        
        return maxLen;

    }
    public static void main(String[] args) {
        String str = "aabbcc";
        System.out.println(LongestSubString(str, 4));
    }
}
