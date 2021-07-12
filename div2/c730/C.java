package com.cf.div2.c730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

    static PrintWriter out = new PrintWriter(System.out);

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static int max = 1000000;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            double c = sc.nextDouble();
            double m = sc.nextDouble();
            double p = sc.nextDouble();
            double v = sc.nextDouble();
            double ans = solve(c * max, m * max, p * max, v * max, 1);
            out.println(String.format("%.12f", ans));
        }
        out.close();
    }

    private static double solve(double c, double m, double p, double v, int len) {
        double ans = (p / max) * len;
        if (c > 0) {
            if (c > v) {
                if (m > 0) {
                    ans += (c / max) * solve(c - v, m + v / 2, p + v / 2, v, len + 1);
                } else {
                    ans += (c / max) * solve(c - v, 0, p + v, v, len + 1);
                }
            } else {
                if (m > 0) {
                    ans += (c / max) * solve(0, m + c / 2, p + c / 2, v, len + 1);
                } else {
                    ans += (c / max) * solve(0, 0, p + c, v, len + 1);
                }
            }
        }
        if (m > 0) {
            if (m > v) {
                if (c > 0) {
                    ans += (m / max) * solve(c + v / 2, m - v, p + v / 2, v, len + 1);
                } else {
                    ans += (m / max) * solve(0, m - v, p + v, v, len + 1);
                }
            } else {
                if (c > 0) {
                    ans += (m / max) * solve(c + m / 2, 0, p + m / 2, v, len + 1);
                } else {
                    ans += (m / max) * solve(0, 0, p + m, v, len + 1);
                }
            }
        }
        return ans;
    }
}