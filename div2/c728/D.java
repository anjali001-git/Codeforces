package com.cf.div2.c728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//Explanation : https://www.youtube.com/watch?v=wzQBApMX3oE

public class D {

    static PrintWriter out = new PrintWriter(System.out);
    static List<Integer>[] adjList;
    static long[][] prob;
    static long MOD = 1000000007L;
    static long[] fac, invfac;

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        adjList = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjList[a].add(b);
            adjList[b].add(a);
        }

        //modular inverse calculation
        fac = new long[420];
        invfac = new long[420];
        fac[0] = invfac[0] = 1L;
        for (int i = 1; i < 420; i++) {
            fac[i] = (fac[i - 1] * i) % MOD;
            invfac[i] = power(fac[i], MOD - 2, MOD);
        }

        //dp for probability calculation
        prob = new long[n][n];
        for (int i = 0; i < n; i++) {
            prob[0][i] = 1L;
            prob[i][0] = 0L;
        }
        for (int i = 0; i < n; i++) {
            prob[i][0] = 0L;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                prob[i][j] = (invfac[2] * prob[i - 1][j] + invfac[2] * prob[i][j - 1]) % MOD;
            }
        }

        //result calculation
        long invProb = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                invProb += solve(j, i, n);
                if (invProb >= MOD) {
                    invProb -= MOD;
                }
            }
        }
        out.println(invProb);
        out.close();
    }

    private static long solve(int a, int b, int n) {
        int[] par = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        par[a] = -1;
        visited[a] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    par[neighbor] = node;
                    visited[neighbor] = true;
                }
            }
        }

        boolean[] onLine = new boolean[n + 1];
        int lastNode = b;
        List<Integer> path = new ArrayList<>();
        while (lastNode != a) {
            onLine[lastNode] = true;
            path.add(lastNode);
            lastNode = par[lastNode];
        }
        onLine[a] = true;
        path.add(a);

        DisjointSetUnion dsu = new DisjointSetUnion(n);
        for (int i = 1; i <= n; i++) {
            for (int neighbor : adjList[i]) {
                if (onLine[neighbor] && onLine[neighbor]) {
                    continue;
                }
                dsu.union(i, neighbor);
            }
        }

        int pathLen = path.size();
        long result = 0L;
        for (int i = pathLen - 1; i >= 0; i--) {
            long probability = (dsu.dsuSize[dsu.find(path.get(i))] * invfac[n]) % MOD;
            probability = (probability * fac[n - 1]) % MOD;
            probability = (probability * prob[pathLen - 1 - i][i]) % MOD;
            result += probability;
            if (result >= MOD) {
                result -= MOD;
            }
        }
        return result;
    }

    public static long power(long x, long y, long p) {
        //0^0 = 1
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % p;
            }
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
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

    static class DisjointSetUnion {

        int[] dsu; // representative of each disjoint set
        int[] dsuSize; // size of each disjoint set

        DisjointSetUnion(int size) {
            dsu = new int[size + 1];
            dsuSize = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                dsu[i] = i;
                dsuSize[i] = 1;
            }
        }

        int find(int x) {
            return dsu[x] == x ? x : find(dsu[x]);
        }

        int union(int x, int y) {
            int xRepresentative = find(x);
            int yRepresentative = find(y);
            if (xRepresentative != yRepresentative) {
                dsu[xRepresentative] = dsu[yRepresentative];
                dsuSize[yRepresentative] += dsuSize[xRepresentative];
            }
            return dsuSize[yRepresentative];
        }
    }
}