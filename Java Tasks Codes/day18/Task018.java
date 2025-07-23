package day18;

import java.util.LinkedList;
import java.util.Queue;

public class Task018 {
	
	static class Node{
		Node left,right;
		int data;
		public Node(int data) {
			this.data = data;
		}
	}
	
	static void reverseAlternateLevels(Node root) {
		if(root==null) {
			return ;
		}
		
		helperReverse(root.left, root.right, 1);
	}
	static void helperReverse(Node left, Node right, int level) {
		if(left==null ) return ;
		if(level %2 ==1) {
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
		}
		helperReverse(left.left, right.right, level+1);
		helperReverse(left.right, right.left, level+1);
	}
	public static void printPreOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
	
	static void reverseAlternateQueue(Node root) {
		if(root==null) {
			return ;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
	}

	public static void main(String[] args) {
		 Node[] nodes = new Node[16];

	        for (int i = 0; i <= 15; i++) {
	            nodes[i] = new Node(i);
	        }

	        for (int i = 1; i <= 7; i++) {
	            nodes[i].left = nodes[2 * i];
	            nodes[i].right = nodes[2 * i + 1];
	        }
	        
	        reverseAlternateLevels(nodes[1]);
	        printPreOrder(nodes[1]);


	}
}
