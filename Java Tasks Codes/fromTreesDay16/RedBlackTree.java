package fromTreesDay16;

public class RedBlackTree {
	static class RBNode{
		int data;
		boolean isRed;
		RBNode left,right,parent;
		
		RBNode(int data) {
			this.data = data;
		}
	}
	
	static class RBTree{
		private RBNode root;
		
		void insert(int val) {
			RBNode insertedNode = insert(root, val);
			fixVoilation(insertedNode);
		}
		
		private RBNode insert(RBNode node ,int val) {
			if(node == null) {
				RBNode aNode = new RBNode(val);
				aNode.isRed = true;
				aNode.parent = node;
				return aNode;
			}
			if(node.data > val ) {
				node.left = insert(node.left, val);
				node.left.parent = node;
			}
			else if(node.data<val) {
				node.right = insert(node.right, val);
				node.right.parent = node;
			}else {
				return node;
			}
			
			return node;
			
		}

		private void fixVoilation(RBNode node) {
		    while (node != root && node.parent != null && node.parent.isRed) {
		        RBNode parent = node.parent;
		        RBNode grandparent = parent.parent;

		        if (grandparent == null) break;

		        if (parent == grandparent.left) {
		            RBNode uncle = grandparent.right;
		            if (uncle != null && uncle.isRed) {
		                parent.isRed = false;
		                uncle.isRed = false;
		                grandparent.isRed = true;
		                node = grandparent;
		            } else {
		                if (node == parent.right) {
		                    node = parent;
		                    leftRotate(node);
		                    parent = node.parent;
		                }
		               
		                parent.isRed = false;
		                grandparent.isRed = true;
		                rightRotate(grandparent);
		            }
		        } else {
		            
		            RBNode uncle = grandparent.left;

		            if (uncle != null && uncle.isRed) {
		                parent.isRed = false;
		                uncle.isRed = false;
		                grandparent.isRed = true;
		                node = grandparent;
		            } else {
		                if (node == parent.left) {
		                    node = parent;
		                    rightRotate(node);
		                    parent = node.parent;
		                }
		                parent.isRed = false;
		                grandparent.isRed = true;
		                leftRotate(grandparent);
		            }
		        }
		    }

		    root.isRed = false;
		}
		
		private void leftRotate(RBNode node) {
			RBNode rc = node.right;
			RBNode rcLeft  = rc.left;
			
			rc.left = node;
			node.right = rcLeft;
			
			if(rcLeft!=null) {
				rcLeft.parent = node;
			}
			
			if(node.parent==null) {
				root = rc;
			}else if(node.parent.left == node) {
				node.parent.left = rc;
			}else {
				node.parent.right = rc;
			}
			
			node.parent = rc;
		}
		
		private void rightRotate(RBNode node) {
			RBNode lc = node.left;
			RBNode lcRight = lc.right;
			
			lc.right = node;
			node.left = lcRight;
			
			if(lcRight!=null) {
				lcRight.parent = node;
			}
			if(node.parent==null) {
				root = lc;
			}else if(node.parent.left == node) {
				node.parent.left = lc;
			}else {
				node.parent.right = lc;
			}
			node.parent = lc;
		}
	}
}
