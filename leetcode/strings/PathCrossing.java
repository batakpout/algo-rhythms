package leetcode.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * LC: 1496 E
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively.
 * You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 *
 * Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 *
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 *
 */
public class PathCrossing {

    //TC: O(N)
    public static boolean isPathCrossing(String path) {

        int x = 0, y = 0;
        String coord = x + "," + y;
        Set<String> s = new HashSet<>();
        s.add(coord);
        for (char dir : path.toCharArray()) {
            if (dir == 'N') y++;
            else if (dir == 'S') y--;
            else if (dir == 'E') x++;
            else if (dir == 'W') x--;

            coord = x + "," + y;
            if (s.contains(coord)) return true;
            s.add(coord);
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter path:");
        String path = sc.nextLine();
        boolean result = isPathCrossing(path);
        System.out.println("IsPathCrossing: " + result);

    }
}