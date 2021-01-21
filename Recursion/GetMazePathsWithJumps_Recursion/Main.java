import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(getMazePaths(0,0,n-1,m-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        
        if(sr == dr && sc == dc){
            ArrayList<String> ar = new ArrayList<>();
            ar.add("");
            return ar;
        }
         
        ArrayList<String> hpaths ;
        ArrayList<String> vpaths ;
        ArrayList<String> dpaths ;
        ArrayList<String> fpaths = new ArrayList<>();
        //horizontal
        for(int hm = 1;hm<=dc - sc;hm++){
            hpaths = getMazePaths(sr,sc+hm,dr,dc);
            for(String val:hpaths){
                fpaths.add("h"+hm+val);
            }
        }
        //vertical
        for(int vm = 1;vm<=dr - sr;vm++){
            vpaths = getMazePaths(sr+vm,sc,dr,dc);
            for(String val:vpaths){
                fpaths.add("v"+vm+val);
            }
        }
        //diagmol 
        for(int dm = 1; dm <= dc-sc && dm<=dr-sr;dm++){
            dpaths = getMazePaths(sr+dm,sc+dm,dr,dc);
            for(String val:dpaths){
                fpaths.add("d"+dm+val);
            }
        }
        return fpaths;
    }

}