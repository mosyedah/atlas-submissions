package day18;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Task003 {
	
	static class TreeNode{
		TreeNode left,right;
		int data;
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	static void VTraversal(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode leftest = null, rightest = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == 0) leftest = node;
                if (i == size - 1) rightest = node;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if (leftest != null) System.out.print(leftest.data + " ");
            if (rightest != null && rightest != leftest) System.out.print("----"+rightest.data + " ");
            System.out.println();
        }
    }
	
	static void rightSideViewHelper(TreeNode root, int level, LinkedList<Integer> liss) {
		if(root == null) {
			return;
		}
		if(level==liss.size()) {
			liss.add(root.data);
		}
		
		rightSideViewHelper(root.right, level+1,liss);
		rightSideViewHelper(root.left, level+1,liss);
	}
	static List<Integer> rightSideView(TreeNode root){
		LinkedList<Integer> liss = new LinkedList<Integer>();
		rightSideViewHelper(root, 0, liss);
		return liss;
	}

	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(11);
		root.left = new TreeNode(22);
		root.right = new TreeNode(33);
		root.left.left = new TreeNode(44);
		root.left.right = new TreeNode(55);
		root.right.left = new TreeNode(66);
		root.right.right = new TreeNode(77);
//		root.right.right.right = new TreeNode(99);
//		root.left.left.left = new TreeNode(88); 
		
		
		System.out.println(rightSideView(root));
	}
}
