package n2;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortIterativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");

        int[] v = new int[text.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(text[i]);
        }

        insertionSort(v);
        System.out.println(Arrays.toString(v));
    }

    public static void insertionSort(int[] v) {
        for (int i = 1; i < v.length; i++) {

            for (int j = i; j > 0 ; j--) {
                if(v[j] < v[j-1]) {
                    int temp = v[j-1];
                    v[j-1] = v[j];
                    v[j] = temp;
                } else{
                    break;
                }
            }
        }
    }
}
