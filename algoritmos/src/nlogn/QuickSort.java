package nlogn;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");

        int[] v = new int[text.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(text[i]);
        }

        quickSort(v, 0, v.length-1);
        System.out.println(Arrays.toString(v));
    }

    public static void quickSort(int[] v, int left, int right) {
        if (left < right) {
            int indexPivot = partition(v, left, right);
            quickSort(v, left, indexPivot - 1);
            quickSort(v, indexPivot + 1, right);
        }
    }

    private static int partition(int[] v, int left, int right) {
        int i = left;
        int pivot = v[i];
        for (int j = left+1; j < right+1; j++) {
            if(v[j] <= pivot) {
                i++;
                int temp = v[i];
                v[i] = v[j];
                v[j] = temp;
            }
        }

        int temp = v[left];
        v[left] = v[i];
        v[i] = temp;

        return i;
    }

}
