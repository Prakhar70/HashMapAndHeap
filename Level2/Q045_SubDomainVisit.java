package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q045_SubDomainVisit {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String str:cpdomains){
            String[] countDomainStr = str.split(" ");
            int count=Integer.parseInt(countDomainStr[0]);
            String domain=countDomainStr[1];
            String[] domains = domain.split("\\.");
            String keyStr = "";
            for(int i=domains.length-1;i>=0;i--){
                if(i==domains.length-1)
                    keyStr=domains[i];
                else{
                    keyStr=domains[i]+'.'+keyStr;
                }
                map.put(keyStr, map.getOrDefault(keyStr,0)+count);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key)+" "+key);
        }
        return ans;
    }
}
