public class MinHeap {

    private MinHeapNode root;
    private int height;
    private MinHeap left;
    private MinHeap right;

    public MinHeap(){
        root = null;
        left = null;
        right = null;
        height = 0;
    }

    public void insert(int value) {

        // first node of minheap becomes root
        if (root == null) {
            this.root = new MinHeapNode(value);
            this.height += 1;
            return;
        }

        // if inserting value is smaller than root value
        int keptValue = root.getValue();
        int insertingValue = value;

        // If root value is smaller than inserting value
        if (value < root.getValue()) {
            insertingValue = root.getValue();
            keptValue = value;
        }

        MinHeapNode newNode = new MinHeapNode(keptValue);
        root = newNode;

        // if left or right is null; left gets a height += 1
        if (this.left == null) {
            this.left = new MinHeap();
            this.left.insert(insertingValue);
            height += 1;
            return;
        }
        else if (this.right == null) {
            this.right = new MinHeap();
            this.right.insert(insertingValue);
            return;
        }
        else {
            // if both not null, compare heights and add to smallest height
            if (this.left.height <= this.right.height) {
                this.left.insert(insertingValue);
                height = this.left.height + 1;
            }
            else {
                this.right.insert(insertingValue);
                height = this.right.height + 1;
            }
        }

   }

    public int getHeight() {
        return height;
    }

    public String postorder() {

        String result = "";

        if(this.left != null) {
            result = result + this.left.postorder() + ",";
        }
        if(this.right != null) {
            result = result + this.right.postorder() + ",";
        }
        if(this.root != null) {
            result = result + this.root.getValue();
        }

        return result;
    }

    public String preorder() {

        String result = "";

        if(this.root != null) {
            result = result + this.root.getValue() + ","; // just add conditional statement
                                                    // with % 2 for only odd values
        }
        if(this.left != null) {
            result = result + this.left.preorder() + ",";
        }
        if(this.right != null) {
            result = result + this.right.preorder();
        }

        if(result.length() > 0 && result.charAt(result.length() - 1) == ',') {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }
}
