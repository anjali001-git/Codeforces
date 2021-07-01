package com.cf.div2.c728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B {

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
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(sc.nextInt(), i);
            }
            int ans = 0;
            for (int i = 3; i < 2*n; i++) {
                for (int j = 1; j*j < i; j++) {
                    if (i % j == 0) {
                        if (map.containsKey(j) && map.containsKey(i / j)) {
                            ans += map.get(j) + map.get(i / j) == i ? 1 : 0;
                        }
                    }
                }
            }
            out.println(ans);
        }
        out.close();
    }
}