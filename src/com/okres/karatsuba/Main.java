package com.okres.karatsuba;

public class Main {

    public static void main(String[] args) {
        long currentTimeMillisBefore = System.currentTimeMillis();
        System.out.println(karatsuba(543712312912999999L, 9849929259292929L));
        long currentTimeMillisAfter = System.currentTimeMillis();
        System.out.println(currentTimeMillisAfter - currentTimeMillisBefore);
    }

    private static long karatsuba(long x, long y) {
        long n = Math.max(
                Long.toString(x).length(),
                Long.toString(y).length());
        if (n == 1) {
            return x * y;
        } else {
            long m = n / 2 + n % 2;

            long a = x / (long) Math.pow(10, m);
            long b = x % (long) Math.pow(10, m);
            long c = y / (long) (Math.pow(10, m));
            long d = y % (long) (Math.pow(10, m));

            /*recursive calls*/
            long ac = karatsuba(a, c);
            long bd = karatsuba(b, d);
            long pq = karatsuba((a + b), (c + d));

            return (long) ((Math.pow(10, 2 * m) * ac) + (Math.pow(10, m) * (pq - ac - bd)) + bd);
        }
    }
}
