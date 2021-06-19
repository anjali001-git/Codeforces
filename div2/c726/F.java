//package com.cf.div2.c726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class F {

    static PrintWriter out = new PrintWriter(System.out);

    static List<Integer>[] adjList;
    static int[] color;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            adjList = new ArrayList[n + 1];
            color = new int[n + 1];
            long[] init = new long[n + 1];
            long[] target = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                init[i] = sc.nextLong();
            }
            for (int i = 1; i <= n; i++) {
                target[i] = sc.nextLong();
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (adjList[a] == null) {
                    adjList[a] = new ArrayList<>();
                }
                if (adjList[b] == null) {
                    adjList[b] = new ArrayList<>();
                }
                adjList[a].add(b);
                adjList[b].add(a);
            }
            boolean isBipartite = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            //make target 0
            for (int i = 1; i <= n; i++) {
                init[i] -= target[i];
            }
            if (isBipartite) {
                long blackNodesSum = 0;
                long whiteNodesSum = 0;
                for (int i = 1; i <= n; i++) {
                    if (color[i] == 1) {
                        blackNodesSum += init[i];
                    } else {
                        whiteNodesSum += init[i];
                    }
                }
                if (blackNodesSum == whiteNodesSum) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
            } else {
                long sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum += init[i];
                }
                if (sum % 2 == 0) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
            }
        }
        out.close();
    }

    private static boolean bfs(int src) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        color[src] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer currNode = queue.poll();
                if (Objects.nonNull(adjList[currNode])) {
                    for (int neighbor : adjList[currNode]) {
                        if (color[neighbor] == 0) {
                            color[neighbor] = color[currNode] == 1 ? 2 : 1;
                            queue.add(neighbor);
                        } else {
                            if (color[neighbor] == color[currNode]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
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