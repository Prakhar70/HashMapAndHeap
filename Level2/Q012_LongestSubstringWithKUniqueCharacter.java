package Level2;

import java.util.HashMap;


public class Q012_LongestSubstringWithKUniqueCharacter {
    public static int longestkSubstr(String str, int K) {
        int j=0;
        int maxLen =-1;
        HashMap<Character,Integer> map = new HashMap<>();
        int n = str.length();
        for(int i=0;i<n;i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
            if(map.size()==K){
                maxLen = Math.max(maxLen,i-j+1);
            }
            while(map.size()>K){
                map.put(str.charAt(j), map.get(str.charAt(j))-1);
                if(map.get(str.charAt(j))==0){
                    map.remove(str.charAt(j));
                }
                j++;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "aabbcc";
        System.out.println(longestkSubstr(str, 4));
    }
}
