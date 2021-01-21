import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(getMazePaths(0, 0, n - 1, m - 1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList < String > al = new ArrayList < > ();
            al.add("");
            return al;
        } 

        ArrayList < String > hpaths;
        ArrayList < String > vpaths;
        ArrayList < String > fpaths = new ArrayList < > ();
        //horizontal
        if (sc < dc) {
            hpaths = getMazePaths(sr, sc + 1, dr, dc);
            for (String val: hpaths) {
                fpaths.add("h" + val);
            }
        }
        //vertical
        if (sr < dr) {
            vpaths = getMazePaths(sr + 1, sc, dr, dc);
            for (String val: vpaths) {
                fpaths.add("v" + val);
            }
        }
        return fpaths;
    }

}