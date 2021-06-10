package com.cf.div2.c724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {

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
            Node head = null;
            boolean notPossible = false;
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                Node node = new Node(x);
                if (head == null) {
                    head = node;
                } else {
                    if ((head.next != null && x > head.next.value) || (head.prev != null && x < head.prev.value)) {
                        notPossible = true;
                    } else if ((head.next == null || x <= head.next.value) && x > head.value) {
                        if (head.next != null && x == head.next.value) {
                            head = head.next;
                            continue;
                        }
                        Node temp = head.next;
                        head.next = node;
                        node.prev = head;
                        node.next = temp;
                        if (temp != null) {
                            temp.prev = node;
                        }
                        head = node;
                    } else if ((head.prev == null || x >= head.prev.value) && x < head.value) {
                        if (head.prev != null && x == head.prev.value) {
                            head = head.prev;
                            continue;
                        }
                        Node temp = head.prev;
                        head.prev = node;
                        node.next = head;
                        node.prev = temp;
                        if (temp != null) {
                            temp.next = node;
                        }
                        head = node;
                    }
                }
            }
            if (notPossible) {
                out.println("NO");
            } else {
                out.println("YES");

            }        }
        out.close();
    }

    static class Node {
        int value;
        Node prev;
        Node next;
        Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}