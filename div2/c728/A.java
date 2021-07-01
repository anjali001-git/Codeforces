package com.cf.div2.c728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {

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
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n % 2 == 0) {
                for (int i = 1; i <= n; i++) {
                    out.print(i + 1 + " ");
                    out.print(i + " ");
                    i++;
                }
            } else {
                for (int i = 1; i <= n - 3; i++) {
                    out.print(i + 1 + " ");
                    out.print(i + " ");
                    i++;
                }
                out.print(n + " ");
                out.print(n - 2 + " ");
                out.print(n - 1 + " ");
            }
            out.println();
        }
        out.close();
    }
}