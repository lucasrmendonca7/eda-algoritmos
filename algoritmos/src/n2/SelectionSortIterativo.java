package n2;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortIterativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");

        int[] v = new int[text.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(text[i]);
        }

        selectionSort(v);
        System.out.println(Arrays.toString(v));
    }

    public static void selectionSort(int[] v) {
        for (int i = 0; i < v.length; i++) {
            int menorI = i;

            for (int j = i+1; j < v.length; j++) {
                if (v[j] < v[menorI]) {
                    menorI = j;
                }
            }

            int temp = v[i];
            v[i] = v[menorI];
            v[menorI] = temp;
        }
        }
}
