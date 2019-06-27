package com.okres.karatsuba;

public class Main {

    public static void main(String[] args) {
        System.out.println(karatsuba(5437, 9845));
    }

    private static int karatsuba(int x, int y) {

        int n = Math.max(
                Integer.toString(x).length(),
                Integer.toString(y).length());
        if (n == 1) {
            return x * y;
        } else {
            int m = n / 2 + n % 2;

            int a = x / (int) Math.pow(10, m);
            int b = x % (int) Math.pow(10, m);
            int c = y / (int) (Math.pow(10, m));
            int d = y % (int) (Math.pow(10, m));

            int p = a + b;
            int q = c + d;

            /*recursive call*/
            int ac = karatsuba(a, c);
            int bd = karatsuba(b, d);
            int pq = karatsuba(p, q);

            int abcd = pq - ac - bd;
            return (int) ((Math.pow(10, 2 * m) * ac) + (Math.pow(10, m) * abcd) + bd);
        }
















      /*  if (x < 10 && y < 10) {
            return x * y;
        }

        int n = Math.max(
                Integer.valueOf(x).toString().length(),
                Integer.valueOf(y).toString().length());



        return 0;*/
    }
}
