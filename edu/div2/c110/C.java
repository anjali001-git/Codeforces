package com.cf.edu.div2.c110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

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
            String s = sc.next();
            int n = s.length();
            long[][] dp = new long[n + 1][2];
            long result = 0;
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i - 1) == '0') {
                    dp[i][0] = 1L + dp[i - 1][1];
                } else if (s.charAt(i - 1) == '1') {
                    dp[i][1] = 1L + dp[i - 1][0];
                } else {
                    dp[i][0] = 1L + dp[i - 1][1];
                    dp[i][1] = 1L + dp[i - 1][0];
                }
                result += Math.max(dp[i][0], dp[i][1]);
            }
            out.println(result);
        }
        out.close();
    }

    //?10??1100 = 9
    //010??1100
    //010001100 // n^2*2^k
    //010011100
    //0100?1100
    //0101?1100
    //110??1100
    //010101100
    //DP ->
    //9+6+4+3+2+1 = 25

}


