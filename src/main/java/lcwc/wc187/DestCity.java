package lcwc.wc187;

import java.util.*;

public class DestCity {
    public static void main(String[] args) {
        List<List<String>> paths = Arrays.asList(
                Arrays.asList("B", "C"),
                Arrays.asList("D", "B"),
                Arrays.asList("C", "A")
        );
        System.out.println(destCityLRS(paths));
        System.out.println(destCitySRS(paths));
        System.out.println(destCityFast(paths));
    }

    // O(removeAll operation of List) ---- SLOW
    public static String destCityLRS(List<List<String>> paths) {
        Set<String> srcSet = new HashSet<>();
        List<String> dstList = new ArrayList<>();
        for (List<String> path : paths) {
            srcSet.add(path.get(0));
            dstList.add(path.get(1));
        }
        dstList.removeAll(srcSet);
        return dstList.get(0);
    }

    // O(removeAll operation of Set) ---- FAST
    public static String destCitySRS(List<List<String>> paths) {
        Set<String> srcSet = new HashSet<>();
        Set<String> dstSet = new HashSet<>();
        for (List<String> path : paths) {
            srcSet.add(path.get(0));
            dstSet.add(path.get(1));
        }
        dstSet.removeAll(srcSet);
//        return (String) dstSet.toArray()[0];
        return dstSet.iterator().next();
    }

    // O(n)
    public static String destCityFast(List<List<String>> paths) {
        Set<String> srcSet = new HashSet<>();
        for (List<String> path : paths) {
            srcSet.add(path.get(0));
        }
        for (List<String> path : paths) {
            String dst = path.get(1);
            if (!srcSet.contains(dst)) {
                return dst;
            }
        }
        return "INVALID";
    }
}
