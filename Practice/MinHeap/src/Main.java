public class Main {

    public static void main(String[] args) {

        MinHeap heap = new MinHeap();
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);
        heap.insert(10);
        heap.insert(11);
        heap.insert(12);

        System.out.println("height: " + heap.getHeight());

        heap.postorder();

        heap.preorder();
    }
}
