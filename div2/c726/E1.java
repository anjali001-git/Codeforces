package com.cf.div2.c726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class E1 {

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder prefix = new StringBuilder(s.substring(0, i + 1));
            while (prefix.length() < k) {
                prefix.append(prefix);
            }
            prefix.setLength(k);
            result.add(prefix.toString());
        }
        Collections.sort(result);
        out.println(result.get(0));
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
