package Level2;

import java.util.ArrayList;
import java.util.HashMap;

public class Q024_GroupShiftedString {
    public ArrayList<ArrayList<String>> groupShiftedString(String[] arr) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (String str : arr) {
            String key = prepareString(str);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }

    private String prepareString(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<n;i++){
            int diff = str.charAt(i)-str.charAt(i-1);
            if(diff<0){
                diff+=26;
            }
            sb.append(diff);
            if(i!=n-1)
                sb.append("#");
        }
        return sb.toString();
    }
}
