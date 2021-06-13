package com.cf.edu.div2.c110;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class EBruteForceSolution {

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

    static Map<Integer, Node> tree = new HashMap<>();
    static class Node {
        int i;
        long w;
        long c;
        Map<Integer, Node> sons;
        Node par;
        Node(int i, long w, long c, Node par) {
            this.i = i;
            this.w = w;
            this.c = c;
            this.par = par;
            this.sons = new HashMap<>();
        }
    }
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int q = sc.nextInt();
        long w0 = sc.nextLong();
        long c0 = sc.nextLong();
        Node root = new Node(0, w0, c0, null);
        tree.put(0, root);
        int i = 1;
        while (i <= q) {
            int qtype = sc.nextInt();
            if (qtype == 1) {
                int par = sc.nextInt();
                long wi = sc.nextLong();
                long ci = sc.nextLong();
                Node node = new Node(i, wi, ci, tree.get(par));
                Node parent = tree.get(par);
                parent.sons.put(i, node);
                tree.put(i, node);
            } else {
                int vi = sc.nextInt();
                long gold = sc.nextLong();
                long[] result = getAmountandGold(vi, gold);
                System.out.println(result[0] + " " + result[1]);
            }
            i++;
        }
        out.close();
    }

    private static long[] getAmountandGold(int vi, long gold) {
        long[] result = new long[2];
        Stack<Node> path = new Stack<>();
        path.push(tree.get(vi));
        while (vi > 0) {
            Node parent = tree.get(vi).par;
            if (parent.w == 0) {
                break;
            }
            path.push(parent);
            vi = parent.i;
        }
        while (!path.isEmpty() && gold > 0) {
            Node node = path.pop();
            if (node.w > 0) {
                if (node.w < gold) {
                    result[0] += node.w;
                    result[1] += (node.w * node.c);
                    gold -= node.w;
                    node.w = 0;
                } else {
                    result[0] += gold;
                    result[1] += gold * node.c;
                    node.w -= gold;
                    break;
                }
            }
        }
        return result;
    }
}


