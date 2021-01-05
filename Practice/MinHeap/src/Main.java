public class Main {

    public static void main(String[] args) {

        MinHeap heap = new MinHeap();
        heap.insert(7);
        heap.insert(6);
        heap.insert(5);
        heap.insert(4);

        heap.postorder();

        heap.preorder();
    }
}
