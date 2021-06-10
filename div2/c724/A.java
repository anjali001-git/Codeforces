package com.cf.div2.c724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
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
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            Set<Integer> set = new HashSet<>(list);
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int diff = Math.abs(list.get(i) - list.get(j));
                    if (!set.contains(diff)) {
                        q.add(diff);
                        //set.add(diff);
                    }
                }
            }
            while (!q.isEmpty()) {
                int num = q.poll();
                if (set.contains(num)) {
                    continue;
                }
                list.add(num);
                if (list.size() > 300) {
                    break;
                }
                set.add(num);
                for (int i = 0; i < list.size() - 1; i++) {
                    int diff = Math.abs(list.get(i) - num);
                    if (!set.contains(diff)) {
                        q.add(diff);
                    }
                }
            }
            if (list.size() > 300) {
                out.println("NO");
            } else {
                out.println("YES");
                out.println(list.size());
                for (int i : list) {
                    out.print(i + " ");
                }
                out.println();
            }
        }
        out.close();
    }
}