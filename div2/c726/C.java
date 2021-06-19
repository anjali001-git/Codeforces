package com.cf.div2.c726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

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
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int minDiff = Integer.MAX_VALUE;
            int[] pair = new int[2];
            for (int i = 0; i < n - 1; i++) {
                if (arr[i + 1] - arr[i] < minDiff) {
                    minDiff = arr[i + 1] - arr[i];
                    pair[0] = i;
                    pair[1] = i + 1;
                }
            }
            out.print(arr[pair[0]] + " ");
            for (int i = pair[1] + 1; i < n; i++) {
                out.print(arr[i] + " ");
            }
            for (int i = 0; i < pair[0]; i++) {
                out.print(arr[i] + " ");
            }
            out.print(arr[pair[1]]);
            out.println();
        }
        out.close();
    }
}