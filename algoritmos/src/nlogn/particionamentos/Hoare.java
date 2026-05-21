package nlogn.particionamentos;

import java.util.Arrays;
import java.util.Scanner;

public class Hoare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");

        int[] v = new int[text.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(text[i]);
        }

        hoare(v);
        System.out.println(Arrays.toString(v));
    }

    public static void hoare(int[] v) {
        int pivot = v[0];
        int i = 1;
        int j = v.length-1;

        while(i <= j) {

            while (i <= j && v[i] <= pivot) {
                i++;
            }

            while (i <= j && v[j] > pivot) {
                j--;
            }

            if(i < j) {
                int temp = v[i];
                v[i] = v[j];
                v[j] = temp;
            }
        }
        int temp = v[0];
        v[0] = v[j];
        v[j] = temp;
    }
}



