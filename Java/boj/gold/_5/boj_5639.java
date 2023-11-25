package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj_5639 {
    // 이진 검색 트리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));  // 첫 입력값이 초기 root가 됨
        while (true) {
            String input = br.readLine();
            if(input == null || input.equals("")) break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    public static void postOrder(Node node) {
        if(node == null) return ;

        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        System.out.println(node.root);
    }

    public static class Node {
        int root;
        Node left, right;

        public Node(int root) {
            this.root = root;
        }

        public Node(int root, Node left, Node right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }

        public void insert(int node) {
            if(node < this.root) {
                if(this.left == null)
                    this.left = new Node(node);
                else this.left.insert(node);
            }
            else {
                if(this.right == null)
                    this.right = new Node(node);
                else this.right.insert(node);
            }
        }
    }
}
