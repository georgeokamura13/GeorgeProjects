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

        // if left or right is null
        if (this.left == null && this.right == null) {
            this.left = new MinHeap();
            this.left.insert(insertingValue);
            root = newNode;
            height += 1;
            return;
        }
        else if (this.left == null) {
            this.left = new MinHeap();
            this.left.insert(insertingValue);
            root = newNode;
            height += 1;
            return;
        }
        else if (this.right == null) {
            this.right = new MinHeap();
            this.right.insert(insertingValue);
            root = newNode;
            return;
        }
        else {
            // if both not null, compare heights and add to smallest height
            if (this.left.height <= this.right.height) {
                this.left.insert(insertingValue);
                root = newNode;
            }
            else {
                this.right.insert(insertingValue);
                root = newNode;
            }
        }

    }

    public int getHeight() {
        return height;
    }

    public void postorder() {

        if(this.left != null) {
            this.left.postorder();
        }
        if(this.right != null) {
            this.right.postorder();
        }
        if(this.root != null) {
            System.out.println("reading in postorder: " + this.root.getValue());
        }
    }

    public void preorder() {

        if(this.root != null) {
            System.out.println("reading in preorder: " + this.root.getValue()); // just add conditional statement
                                                                                // with % 2 for only odd values
        }
        if(this.left != null) {
            this.left.preorder();
        }
        if(this.right != null) {
            this.right.preorder();
        }

    }
}
