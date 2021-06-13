package com.cf.edu.div2.c110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

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
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder(sc.next());
        sb.reverse();
        char[] str = sb.toString().toCharArray();
        int n = sb.length();
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i >= n / 2) {
                result[i] = str[i] == '?' ? 2 : 1;
            } else {
                if (str[i] == '0') {
                    result[i] = result[2 * i + 2];
                } else if (str[i] == '1') {
                    result[i] = result[2 * i + 1];
                } else {
                    result[i] = result[2 * i + 2] + result[2 * i + 1];
                }
            }
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            int index = sc.nextInt();
            String ch = sc.next();
            str[n - index] = ch.charAt(0);
            int i = n - index;
            while (i >= 0) {
                if (i >= n / 2) {
                    result[i] = str[i] == '?' ? 2 : 1;
                } else {
                    if (str[i] == '0') {
                        result[i] = result[2 * i + 2];
                    } else if (str[i] == '1') {
                        result[i] = result[2 * i + 1];
                    } else {
                        result[i] = result[2 * i + 2] + result[2 * i + 1];
                    }
                }
                i = i == 0 ? -1 : (i - 1) / 2;
            }
            out.println(result[0]);
        }
        out.close();
    }
}


