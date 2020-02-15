package level.second.task.second;

public class TreeNode {

    private TreeNode parent;
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode parent) {
        this.data = data;
        this.parent = parent;
    }

    public TreeNode add(int value) throws Exception {
        if (value > data) {
            if (right == null) {
                right = new TreeNode(value, this);
                return right;
            } else {
                return right.add(value);
            }
        }
        if (value < data) {
            if (left == null) {
                left = new TreeNode(value, this);
                return left;
            } else {
                return left.add(value);
            }
        }
        throw new Exception("Value already exists in the tree");
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

    public int maxDepth() {
        int leftDepth = left != null ? left.maxDepth() : 0;
        int rightDepth = right != null ? right.maxDepth() : 0;

        return Integer.max(leftDepth,rightDepth)+1;
    }
}
