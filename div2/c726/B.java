package com.cf.div2.c726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

    static class Point {
        long x;
        long y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextInt();
            long m = sc.nextInt();
            long x = sc.nextInt();
            long y = sc.nextInt();
            Point p1 = new Point(1, 1);
            Point p2 = new Point(n, 1);
            Point p3 = new Point(n, m);
            Point p4 = new Point(1, m);
            Point start = new Point(x, y);
            Point ans1, ans2;

            long dist1 = getDist(p1, p2, start);
            long dist2 = getDist(p2, p3, start);
            long dist3 = getDist(p3, p4, start);
            long dist4 = getDist(p4, p1, start);
            long dist5 = getDist(p1, p3, start);
            long dist6 = getDist(p2, p4, start);
            long maxdist = dist1;
            ans1 = p1;
            ans2 = p2;
            if (dist2 > maxdist) {
                maxdist = dist2;
                ans1 = p2;
                ans2 = p3;
            }
            if (dist3 > maxdist) {
                maxdist = dist3;
                ans1 = p3;
                ans2 = p4;
            }
            if (dist4 > maxdist) {
                maxdist = dist4;
                ans1 = p4;
                ans2 = p1;
            }
            if (dist5 > maxdist) {
                maxdist = dist5;
                ans1 = p1;
                ans2 = p3;
            }
            if (dist6 > maxdist) {
                maxdist = dist6;
                ans1 = p2;
                ans2 = p4;
            }
            if (ans1.x == start.x && ans1.y == start.y) {
                ans1 = ans2;
            }
            if (ans2.x == start.x && ans2.y == start.y) {
                ans2 = ans1;
            }
            out.println(ans1.x + " " + ans1.y + " " + ans2.x + " " + ans2.y);
         }
        out.close();
    }

    private static long getDist(Point p1, Point p2, Point start) {
        return Math.abs(start.x - p1.x) + Math.abs(start.y - p1.y)
                + Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y)
                + Math.abs(p2.x - start.x) + Math.abs(p2.y - start.y);
    }
}