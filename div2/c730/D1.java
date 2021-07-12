package com.cf.div2.c730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class D1 {

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int fasterScanner() {
        try {
            boolean in = false;
            int res = 0;
            for (; ; ) {
                int b = System.in.read() - '0';
                if (b >= 0) {
                    in = true;
                    res = 10 * res + b;
                } else if (in) {
                    return res;
                }
            }
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = fasterScanner();
        while (t-- > 0) {
            int n = fasterScanner();
            int k = fasterScanner();
            int pass = 0;
            for (int i = 0; i < n; i++) {
                int q = pass ^ i;
                out.println(q);
                out.flush();
                int r = fasterScanner();
                if (r == 1) {
                    break;
                }
                pass ^= q;
            }
        }
        out.close();
    }

    private static void shuffle(int[] arr, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
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