package com.cf.edu.div2.c110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EBinaryLiftSolution {

    static PrintWriter out = new PrintWriter(System.out);
    static int[][] up;
    static long[][] weightCost;

    public static void main(String[] args) {
        up = new int[300005][25];
        weightCost = new long[300005][2];
        FastScanner sc = new FastScanner();

        int q = sc.nextInt();
        long w0 = sc.nextLong();
        long c0 = sc.nextLong();
        binaryLift(0, -1);
        weightCost[0][0] = w0;
        weightCost[0][1] = c0;

        int i = 1;
        while (i <= q) {
            int qtype = sc.nextInt();
            if (qtype == 1) {
                int par = sc.nextInt();
                long wi = sc.nextLong();
                long ci = sc.nextLong();
                weightCost[i][0] = wi;
                weightCost[i][1] = ci;
                binaryLift(i, par);
            } else {
                int vi = sc.nextInt();
                long gold = sc.nextLong();
                long[] result = getAmountandGold(vi, gold);
                out.println(result[0] + " " + result[1]);
                out.flush();
            }
            i++;
        }
        out.close();
    }

    private static void binaryLift(int src, int par) {
        up[src][0] = par;
        for (int i = 1; i < 25; i++) {
            if (up[src][i - 1] != -1) {
                up[src][i] = up[up[src][i - 1]][i - 1];
            } else {
                up[src][i] = -1;
            }
        }
    }

    private static long[] getAmountandGold(int vi, long gold) {
        long[] result = new long[2];
        while (gold > 0) {
            int index = vi;
            for (int i = 24; i >= 0; i--) {
                int par = up[index][i];
                if (par != -1 && weightCost[par][0] > 0) {
                    index = par;
                }
            }

            long minGold = Math.min(weightCost[index][0], gold);
            result[0] += minGold;
            result[1] += (minGold * weightCost[index][1]);
            gold -= minGold;
            weightCost[index][0] -= minGold;
            if (index == vi) {
                break;
            }
        }
        return result;
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


