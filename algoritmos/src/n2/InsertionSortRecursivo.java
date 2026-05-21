package n2;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");

        int[] v = new int[text.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(text[i]);
        }

        insertionSort(v, 1);
        System.out.println(Arrays.toString(v));
    }

    public static void insertionSort(int[] v, int n) {
        if(n == v.length) return;

        for (int j = n; j > 0; j--) {
            if (v[j] < v[j-1]) {
                int temp = v[j];
                v[j] = v[j-1];
                v[j-1] = temp;
            } else {
                break;
            }
        }
        insertionSort(v,n+1);
    }
}
