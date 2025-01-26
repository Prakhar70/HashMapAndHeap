package Level2;

import java.util.HashMap;

public class CountSubStringWithAtMostKUniqueCharacter {
    public static int countSubstring(String str, int k){
        int n = str.length();
        int j=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<n;i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
            while(map.size()>k){
                map.put(str.charAt(j), map.get(str.charAt(j))-1);
                cnt+=i-j;
                if(map.get(str.charAt(j))==0){
                    map.remove(str.charAt(j));
                }
                j++;
            }
        }
        int n1 = n-j;
        cnt+=n1*(n1+1)/2;
        return cnt;
    }
    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println(countSubstring(str, 2));
    }
}
