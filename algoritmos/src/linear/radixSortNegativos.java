package linear;

import java.util.Arrays;
import java.util.Scanner;

class radixSortNegativos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text = sc.nextLine().split(" ");
        int d = sc.nextInt();

        int[] v = new int[text.length];

        for (int i = 0; i < v.length; i++) {
            v[i] = Integer.parseInt(text[i]);
        }

        radix(v, d);
    }

    public static void counting(int[] v, int divisor) {
        int menor = getLowerDigit(v, divisor);

        int[] c;

        if(menor < 0) {
            c = new int[10 - menor];
        } else {
            c = new int[10];
        }


        //freq
        for (int i = 0; i < v.length; i++) {
            int digito = (v[i] / divisor) % 10;
            c[digito - menor] += 1;
        }

        //cumulativa
        for (int i = 0; i < c.length - 1; i++) {
            c[i+1] += c[i];
        }

        //transferir
        int[] b = new int[v.length];
        for (int i = v.length-1; i >= 0; i--) {
            int digito = (v[i] / divisor) % 10;
            b[c[digito - menor] - 1] = v[i];
            c[digito - menor] -= 1;
        }

        for (int i = 0; i < v.length; i++) {
            v[i] = b[i];
        }
    }

    private static int getLowerDigit(int[] v, int divisor) {
        int menor = (v[0] / divisor) % 10;
        for (int i = 0; i < v.length; i++) {
            int digito = (v[i] / divisor) % 10;

            if(digito < menor) {
                menor = digito;
            }
        }
        return menor;
    }

    public static void radix(int[] v, int digitos) {
        int divisor = 1;

        for (int i = 0; i < digitos; i++) {
            counting(v, divisor);

            System.out.println(Arrays.toString(v));

            divisor *= 10;
        }
    }
}

