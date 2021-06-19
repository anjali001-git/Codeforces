package com.cf.div2.c726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n % 2 == 1) {
                out.println("Bob");
            } else if ((n & (n - 1)) != 0) {
                out.println("Alice");
            } else {
                if ((Math.log(n) / Math.log(2)) % 2 == 0) {
                    out.println("Alice");
                } else {
                    out.println("Bob");
                }
            }
        }
        out.close();
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