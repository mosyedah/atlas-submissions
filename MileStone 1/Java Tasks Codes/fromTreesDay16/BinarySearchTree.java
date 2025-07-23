package fromTreesDay16;

public class BinarySearchTree<T extends Comparable<T>> {
	private TreeNode<T> root;
	
	void insert(T val){
	       
	       if(root == null ) {
	           root = new TreeNode<T>(val);
	           return;
	   }
	   
	   TreeNode<T> current = root;
	   while(current!=null){
	       if(current.data.compareTo(val)>0){
	           if(current.left==null){
	               current.left = new TreeNode<T>(val);
	               break;
	           }
	           current = current.left;
	       }
	       if(current.data.compareTo(val)==0)break;
	       if(current.data.compareTo(val)<0){
	           if(current.right==null){
	               current.right = new TreeNode<T>(val);
	               break;
	           }
	           current = current.right;
	       }
	   }

	}
	
	void inOrderTraversal() {
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(TreeNode<T> root) {
		if (root==null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.println(root.data+ " ");
		inOrderTraversal(root.right);
	}
	
	private boolean containsValue(T val) {
	    TreeNode<T> current = root;
	    while (current != null) {
	        int cmp = val.compareTo(current.data);
	        if (cmp == 0) {
	            return true;
	        } else if (cmp < 0) {
	            current = current.left;
	        } else {
	            current = current.right;
	        }
	    }
	    return false;
	}



	
	boolean delete(T val) {
        TreeNode<T> current = root;
        TreeNode<T> prev = null;

        while (current != null) {
            if (current.data.compareTo(val) == 0) {
                break;
            } else if (current.data.compareTo(val) > 0) {
                prev = current;
                current = current.left;
            } else {
                prev = current;
                current = current.right;
            }
        }

        // if val not found 
        if (current == null) return false;

        if (isLeaf(current)) {
            return deleteLeafNode(current, prev);
        }
        if (haveSingleChild(current)) {
            return delNodeWithSingleChild(current, prev);
        }

        // in-order predecessor if node has 2 children
        TreeNode<T> todel = current;
        prev = current;
        current = current.left;

        while (current.right != null) {
            prev = current;
            current = current.right;
        }

        todel.data = current.data;
        if (isLeaf(current)) return deleteLeafNode(current, prev);
        else if (haveSingleChild(current)) return delNodeWithSingleChild(current, prev);

        return true;
    }

    private boolean delNodeWithSingleChild(TreeNode<T> current, TreeNode<T> prev) {
        if (current == root) {
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
            return true;
        }

        if (current.left != null) {
            if (prev.left == current) prev.left = current.left;
            else prev.right = current.left;
        } else {
            if (prev.left == current) prev.left = current.right;
            else prev.right = current.right;
        }

        return true;
    }

    private boolean deleteLeafNode(TreeNode<T> current, TreeNode<T> prev) {
        if (current == root) root = null;
        else {
            if (prev.left == current) prev.left = null;
            else prev.right = null;
        }
        return true;
    }

    private boolean isLeaf(TreeNode<T> node) {
        return node.left == null && node.right == null;
    }

    private boolean haveSingleChild(TreeNode<T> node) {
        return (node.left == null && node.right != null) ||
               (node.left != null && node.right == null);
    }



	
	public static void main(String[] args) {
		 BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		    bst.insert(50);
		    bst.insert(30);
		    bst.insert(70);
		    bst.insert(20);
		    bst.insert(40);
		    bst.insert(60);
		    bst.insert(80);
		    
		    
		    
		    System.out.println("In-order traversal:");
		    bst.inOrderTraversal();
//		    
//		    bst.delete(70);
//		    


//		    System.out.println("Value 504 is prsent::? "+bst.containsValue(504));
		    System.out.println("Value 50 is deleted::? "+bst.delete(50));
		    
		    System.out.println("In-order traversal after deletion:");
		    bst.inOrderTraversal();
	}
}
