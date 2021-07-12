package com.cf.div2.c730;

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
            long a = sc.nextLong();
            long b = sc.nextLong();
            long diff = Math.abs(a - b);
            if (diff == 0) {
                out.println(0 + " " + 0);
            } else {
                long mod = a % diff;
                out.print(diff + " ");
                out.println(Math.min(mod, diff - mod));
            }
        }
        out.close();
    }
}