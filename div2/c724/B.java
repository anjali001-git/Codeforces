package com.cf.div2.c724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B {

    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            Set<String> set = new HashSet<>();
            String ans = getMEX(s, set, n);

            out.println(ans);
        }
        out.close();
    }

    private static String getMEX(String s, Set<String> set, int n) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= n - i; j++) {
                set.add(s.substring(j, j + i));
            }
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            if (!set.contains(sb.toString())) {
                return sb.toString();
            }
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                sb.append(ch2);
                if (!set.contains(sb.toString())) {
                    return sb.toString();
                }
            }

        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
                for (char ch3 = 'a'; ch3 <= 'z'; ch3++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ch);
                    sb.append(ch2);
                    sb.append(ch3);
                    if (!set.contains(sb.toString())) {
                        return sb.toString();
                    }
                }
            }
        }
        return "";
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