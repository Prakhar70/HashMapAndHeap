package Level2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class TicketItinery {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String s=scn.next();
            String d=scn.next();
            map.put(s,d);
        }
        List<String> route = getRoute(map);
        System.out.println(route);
    }

    private static List<String> getRoute(HashMap<String,String> map) {
            List<String> route = new ArrayList<>();
            String sourceRoute = null;
            HashSet<String> destinationSet = new HashSet<>();
            for(String source:map.keySet()){
                String destination = map.get(source);
                destinationSet.add(destination);
            }
            for(String source:map.keySet()){
                if(!destinationSet.contains(source)){
                    sourceRoute = source;
                    break;
                }
            }
            String source = sourceRoute;
            while(source!=null){
                route.add(source);
                source=map.get(source);
            }
            return route;
    }
}
