class Solution {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        int cnt;
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if(nums.length == 0) return res;
        TreeNode root = new TreeNode();
        root.val = nums[nums.length - 1];
        root.cnt = 1;
        res.add(0);
        for(int i = nums.length - 2; i >= 0; i--) {
            res.add(insert(root, nums[i]));
        }
        return res;
    }
    private int insert(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode();
            root.val = val;
            root.cnt = 1;
            return 1;
        }
        if(root.val == val) {
            root.cnt += 1;
            return root.cnt;
        }
        if(root.val > val) {
            return insert(root.left, val) + root.cnt;
        } else {
            return insert(root.right, val) + root.cnt;
        }
    }
}