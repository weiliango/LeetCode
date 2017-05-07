// public class Solution {
// 	int max;
// 	int count;

	// public int [] findMode(TreeNode root) {
	// 	if ( root == null ) return new int[0];
	// 	Set<Integer> list = new HashSet<Integer>();
	// 	Queue<TreeNode> q = new LinkedList<TreeNode>();
	// 	q.add(root);
	// 	max = 0;
	// 	while ( !q.isEmpty() ) {
	// 		TreeNode current = q.poll();
	// 		count = 0;
	// 		helper(root, list, current.val);
          
	// 		if ( count > max ) {
	// 			list.clear();
	// 			list.add(prev.val);
	// 			max = count;
	// 		}
	// 		if ( count == max ) {
	// 			list.add(root.val);
	// 		}  

	// 		if ( current.left != null ) {
	// 			q.add(current.left);
	// 		}
	// 		if ( current.right != null ) {
	// 			q.add(current.right);
	// 		}
	// 	}

	// 	int [] res = new int[list.size()];
	// 	int i = 0;
	// 	for ( Integer value : list ) {
	// 		res[i++] = value;
	// 	}
	// 	return res;
	// }
	// public void helper(TreeNode root, Set<Integer> list, int prev) {
	// 	if ( root == null ) {
	// 		return;
	// 	}

	// 	if ( root.val == prev ) {
	// 		count++;
	// 	} 
		
	// 	helper(root.left, list, prev);
	// 	helper(root.right, list, prev);	

	// }
// }
public class Solution {
	public int [] findMode(TreeNode root) {
	    if(root == null) return new int[0];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue <TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode current = q.poll();
			if ( map.containsKey(current.val)) {
				map.put(current.val, map.get(current.val) + 1);
			} else {
				map.put(current.val, 1);
			}
			if ( current.left != null ) {
				q.add(current.left);
			}
			if ( current.right != null ) {
				q.add(current.right);
			}
		}

		Set <Integer> list = new HashSet<Integer>();
		int max = 0;
		for ( Integer i : map.keySet()) {
			if ( map.get(i) > max ) {
				list.clear();
				list.add(i);
				max = map.get(i);
			}
			if ( map.get(i) == max ) {
				list.add(i);
			}
		}

		int i = 0;
		int [] res = new int[list.size()];
		for ( Integer value : list) {
			res[i++] = value;
		}
		return res;
	}
}