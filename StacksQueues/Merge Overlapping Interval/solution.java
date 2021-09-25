import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }
    public static class Interval implements Comparable<Interval>{
        int starting;
        int ending;
        Interval(int starting, int ending){
            this.starting = starting;
            this.ending = ending;
        }
        
        public int compareTo(Interval other){
            if(this.starting >= other.starting){
                return 1;
            }else {
                return -1;
            }
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Interval[] al = new Interval[arr.length];
        for(int i =0;i<arr.length;i++){
            al[i] = new Interval(arr[i][0], arr[i][1]);
        }
        Arrays.sort(al);
        for(int i = 0 ; i< al.length-1;i++){
            Interval current_obj = al[i];
            Interval next_obj = al[i+1];
            if(current_obj.ending >= next_obj.starting){
                next_obj.starting = current_obj.starting;
                next_obj.ending  = Math.max(next_obj.ending,current_obj.ending);
            }else{
                System.out.println(current_obj.starting + " "+current_obj.ending);
            }
            
        }
        Interval current_obj = al[al.length-1];
        System.out.println(current_obj.starting + " "+current_obj.ending);
    }

}
