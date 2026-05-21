package n2;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");

        int[] v = new int[text.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(text[i]);
        }

        selectionSort(v, 0);
        System.out.println(Arrays.toString(v));
    }

    private static void selectionSort(int[] v, int n) {
        if (n == v.length) return;

        int menorI = n;
        for (int i = n+1; i < v.length ; i++) {
            if(v[i] < v[menorI]) {
                menorI = i;
            }
        }
        int temp = v[menorI];
        v[menorI] = v[n];
        v[n] = temp;
        selectionSort(v, n+1);
    }
}
