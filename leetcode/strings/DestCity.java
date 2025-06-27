package leetcode.strings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.List;
/**
 * LC: E: 1436. Destination City
 You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi.
 Return the destination city, that is, the city without any path outgoing to another city.
 It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 Example 1: Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]] Output: "Sao Paulo"
 Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
 Example 2: Input: paths = [["B","C"],["D","B"],["C","A"]] Output: "A"
 Explanation: All possible trips are:
 Example 3: Input: paths = [["A","Z"]] Output: "Z"
 */
public class DestCity {

    public static String destCity(List<List<String>> paths) {
        Map<String, Integer> m = new HashMap<>();
        for(List<String> path: paths) {
            m.put(path.get(0), 1);
        }

        for(List<String> path: paths) {
            if(!m.containsKey(path.get(1)))
                return path.get(1);
        }
        return "";
    }

    // Using HashSet (preferred - cleaner and slightly faster)
    public static String usingHashSet(List<List<String>> paths) {
       Set<String> s = new HashSet<>();
       for(List<String> path: paths) {
           s.add(path.get(0));
       }
        for(List<String> path: paths) {
            if(!s.contains(path.get(1))) return path.get(1);
        }
        return "";
    }

        public static void main(String[] args) {

    }
}