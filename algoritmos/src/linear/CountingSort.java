package linear;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");
        int k = sc.nextInt();
        int m = sc.nextInt();

        int[] v = new int[text.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(text[i]);
        }

        counting(v, k, m);
    }

    public static void counting(int[] v, int k, int m) {
        int[]c = new int[k - m + 1];

        //freq
        for (int i = 0; i < v.length; i++) {
            c[v[i] - m] += 1;
        }

        //cumulativa
        for (int i = 0; i < c.length-1; i++) {
            c[i+1] += c[i];
        }

        //transferir
        int[] b = new int[v.length];
        for (int i = v.length-1; i >= 0; i--) {
            b[c[v[i] - m]-1] = v[i];
            c[v[i] - m] -= 1;
        }

        System.out.println(Arrays.toString(b));
    }
}
