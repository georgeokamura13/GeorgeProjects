import com.sun.source.tree.Tree;

class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode searchTree(TreeNode tree, int value) {

        if(tree.val == value) {
            return tree;
        }

        if(tree.left != null && (searchTree(tree.left, value) != null)) {
            return searchTree(tree.left, value);
        }
        if(tree.right != null && (searchTree(tree.right, value) != null)) {
            return searchTree(tree.right, value);
        }

        return null;
    }

    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        TreeNode result = null;

        int targetValue = target.val;
        result = searchTree(cloned, targetValue);

        return result;

    }

    /**
     * Testing
     */
    public static void main(String[] args) {
        System.out.println("Testing");

        TreeNode original = new TreeNode(1);
        TreeNode cloned = new TreeNode(1);

        TreeNode target = original;

        if(cloned == getTargetCopy(original, cloned, target)) {
            System.out.println("Passed!");
        }
        else {
            System.out.println("Failed!");
        }
    }
}