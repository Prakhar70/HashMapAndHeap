package Level2;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctSubString {
    public static int countDistinctSubString(String str){
        int i = 0,j = 0;
        Character rc = null;
        int cnt = 0;
        int n = str.length();
        Set<Character> set = new HashSet<>();
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            while(j<n && rc == null){
                if(!set.contains(str.charAt(j))){
                    cnt+=(j-i+1);
                    set.add(str.charAt(j));
                    j++;
                }else{
                    rc = str.charAt(j);
                }
                flag1= true;
            }
            while(rc!=null){
                set.remove(str.charAt(i));
                if(str.charAt(i)==rc){
                    rc = null;
                }
                i++;
                flag2 = true;
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        //String str="aabcbcdbca";
        String str="abcd";
        System.out.println("count="+countDistinctSubString(str));
    }
}
