package com.cf.div2.c726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E2 {

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int start = 0, last = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) > s.charAt(start)) {
                break;
            } else if (s.charAt(i) < s.charAt(start)) {
                last = i;
                start = 0;
            } else { //equal chars
                start = (start + 1) % (last + 1);
            }

        }
        StringBuilder prefix = new StringBuilder(s.substring(0, last + 1));
        while (prefix.length() < k) {
            prefix.append(prefix);
        }
        prefix.setLength(k);
        out.println(prefix);
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