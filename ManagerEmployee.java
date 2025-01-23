import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ManagerEmployee {
    private static void findCount(HashMap<String, String> map) {
        HashMap<String, HashSet<String>> tree = new HashMap();
        String root = "";
        for (String emp : map.keySet()) {
            String mgr = map.get(emp);
            if (emp.equals(mgr)) {
                root = emp;
                continue;
            }
            if (tree.get(mgr) != null) {
                tree.get(mgr).add(emp);
            } else {
                tree.put(mgr, new HashSet<String>());
                tree.get(mgr).add(emp);
            }
        }
        HashMap<String, Integer> hmap = new HashMap<>();
        getChildCountAndUpdateMap(hmap, tree, root);
        System.out.println(hmap);
    }

    private static int getChildCountAndUpdateMap(HashMap<String, Integer> hmap, HashMap<String, HashSet<String>> tree, String root){
        HashSet<String> children = tree.get(root);
        if(children == null){
            hmap.put(root, 0);
            return 0;
        }
        int ImmediateChildsCount = children.size();
        int childCount = ImmediateChildsCount;
        for(String child:children){
            childCount += getChildCountAndUpdateMap(hmap, tree, child);
        }
        hmap.put(root, childCount);
        return childCount;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String emp = scn.next();
            String mgr = scn.next();
            hm.put(emp, mgr);
        }
        findCount(hm);
    }
}
