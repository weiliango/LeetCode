 public class Solution {
 	public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	Queue <TreeNode> q = new LinkedList<TreeNode>();
    	List <List<Integer>> res = new LinkedList<List<Integer>>();
    	
    	if( root == null ) return res;

      	q.add(root);
      	int length = 1;
      	List <Integer> list = new LinkedList<Integer>();

    	while ( !q.isEmpty() ) {

    		TreeNode current = q.poll();
    		list.add(current.val);

    		if ( current.left != null ) {
    			q.add(current.left);
    		}

    		if ( current.right != null ) {
    			q.add(current.right);
    		}

    		length--;
    		
    		if ( length == 0 ) {
    			length = q.size();
    			res.add(list);
    			list = new LinkedList<Integer>();
    		}
    	}

    	Collections.reverse(res);

    	return res; 
    } 
 }