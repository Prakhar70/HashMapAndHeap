package Level2;

import java.util.HashMap;

public class MinSubstringContainingAllCharacterOfAnotherString {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        HashMap<Character,Integer> tfreq = new HashMap<>();
        for(char c:t.toCharArray()){
            tfreq.put(c, tfreq.getOrDefault(c, 0)+1);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int matchCnt = 0;
        int desiredMatchCnt = t.length();
        int minLen = s.length();
        int minSi = 0;
        int minEi = 0;
        int i=0,j=0;
        while(true){
            
            boolean flag1 = false;
            boolean flag2 = false;
            while(i<sLen && matchCnt < desiredMatchCnt){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
                if(tfreq.containsKey(s.charAt(i)) && map.get(s.charAt(i))<=tfreq.get(s.charAt(i))){
                    matchCnt++;
                }
                i++;
                flag1 = true;
            }
            while(j<sLen && matchCnt == desiredMatchCnt){
                //System.out.println(s.substring(j,i)+"-->"+(i-j));
                if(i-j<=minLen){
                    minLen = i-j;
                    minSi = j;
                    minEi = i;
                }
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if(tfreq.containsKey(s.charAt(j)) && map.get(s.charAt(j))<tfreq.get(s.charAt(j))){
                    matchCnt--;
                }
                if(map.get(s.charAt(j))==0){
                    map.remove(s.charAt(j));
                }
                j++;
                flag2 = true;
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return s.substring(minSi, minEi);
    }
}
