package com.cf.div2.c724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F {

    public static int MAXN = 1000005;
    public static long MOD = 1000000007L;
    public static long[] fac;
    public static long[] ifac;
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();

        fac = new long[MAXN];
        ifac = new long[MAXN];

        fac[0] = 1L;
        ifac[0] = 1L;
        for (int k = 1; k < MAXN; k++) {
            fac[k] = (fac[k - 1] * (long) k + MOD) % MOD;
            ifac[k] = modInverse(fac[k], MOD);
        }

      /*
      ifac[MAXN-1] = modInverse(fac[MAXN-1],MOD);
      for(int k = MAXN-2; k >= 0; k--){
         ifac[k] = (ifac[k+1]*(long)(k+1) + MOD)%MOD;
      }*/

        int start = (n + 1) / 2;
        if (start % 2 == 1) {
            start++;
        }

        long answer = 0L;
        for (int k = start; k <= n; k += 2) {
            long prod1 = 1L;
            if (n - k >= 1) {
                //doesn't do first skip
                prod1 = choose(k, n - k);
                //does first skip
                prod1 = (prod1 + choose(k - 1, n - k - 1) + MOD) % MOD;
            }
            long prod2 = (prod1 * 2L + MOD) % MOD;
            long prod3 = (prod2 * fac[k] + MOD) % MOD;
            answer = (answer + prod3 + MOD) % MOD;
        }

        out.println(answer);

        out.close();
    }

    //a choose b, a!/(b!(a-b)!)
    public static long choose(int a, int b) {
        long prod = (fac[a] * ifac[b] + MOD) % MOD;
        long prod2 = (prod * ifac[a - b] + MOD) % MOD;
        return prod2;
    }

    public static long modInverse(long a, long m) {
        long m0 = m;
        long y = 0;
        long x = 1;
        if (m == 1) {
            return 0;
        }

        while (a > 1) {
            // q is quotient
            long q = a / m;

            long t = m;

            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;

            // Update x and y
            y = x - q * y;
            x = t;
        }

        // Make x positive
        if (x < 0) {
            x += m0;
        }

        return x;
    }

    static class FastScanner {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}