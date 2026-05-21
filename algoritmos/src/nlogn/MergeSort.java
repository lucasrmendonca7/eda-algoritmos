package nlogn;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");

        int[] v = new int[text.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(text[i]);
        }

        mergeSort(v, 0, v.length-1);
        System.out.println(Arrays.toString(v));
    }

    public static void mergeSort(int[] v, int left, int right) {
        if(right > left) {
            int meio = (left + right)/2;

            mergeSort(v, left, meio);
            mergeSort(v, meio+1, right);
            merge(v, left, right);

        }
    }

    private static void merge(int[] v, int left, int right) {
        int rightHelper = right - left;
        int[] helper = new int[rightHelper+1];

        for (int i = 0; i < helper.length; i++) {
            helper[i] = v[i + left];
        }

        int middleHelper = rightHelper/2;

        int k = left;
        int i = 0;
        int j = middleHelper + 1;

        while(i <= middleHelper && j <= rightHelper) {
            if (helper[i] <= helper[j]) {
                v[k] = helper[i];
                i++;
            } else{
                v[k] = helper[j];
                j++;
            }
            k++;
        }

        while(i <= middleHelper) {
            v[k] = helper[i];
            i++;
            k++;
        }
    }
}
