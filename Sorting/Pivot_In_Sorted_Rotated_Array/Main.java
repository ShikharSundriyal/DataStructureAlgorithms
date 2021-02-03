import java.io.*;
import java.util.*;

public class Main {

    public static int findPivot(int[] arr) {
        // write your code here
        // we need to compare only arr[mid] and arr[r]

        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[r]) {
                //this means your answer will be on right side, you have to place at mid+1 because arr[mid] was greater than arr[r] so arr[mid] cannot be your answer, so l=mid+1
                l = mid + 1;
            } else if (arr[mid] < arr[r]) {
                // this means your answer will be on the left side, arr[mid] can also be a smallest element so we place right pointer at mid
                r = mid;
            }
        }

        return arr[l];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr);
        System.out.println(pivot);
    }

}