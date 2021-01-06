import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    @Test
    public void getHeightOfEmptyMinHeap() {

        MinHeap sut = new MinHeap();

        int height = sut.getHeight();
        assertEquals(0, height);

    }

    @Test
    public void getPreorderOfEmptyMinHeap() {

        MinHeap sut = new MinHeap();

        String preorder = sut.preorder();
        assertEquals("", preorder);

    }

    @Test
    public void getPostorderOfEmptyMinHeap() {

        MinHeap sut = new MinHeap();

        String postorder = sut.postorder();
        assertEquals("", postorder);

    }

    @Test
    public void getHeightOfOneElementMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(13);

        int height = sut.getHeight();
        assertEquals(1, height);

    }

    @Test
    public void getPreorderOfOneElementMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(13);

        String preorder = sut.preorder();
        assertEquals("13", preorder);

    }

    @Test
    public void getPostorderOfOneElementMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(13);

        String postorder = sut.postorder();
        assertEquals("13", postorder);

    }

    @Test
    public void getHeightOfTwoElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(13);
        sut.insert(64);

        int height = sut.getHeight();
        assertEquals(2, height);

    }

    @Test
    public void getHeightOfTwoElementsMinHeap2() {

        MinHeap sut = new MinHeap();
        sut.insert(64);
        sut.insert(13);

        int height = sut.getHeight();
        assertEquals(2, height);

    }

    @Test
    public void getHeightOfTwoElementsMinHeap3() {

        MinHeap sut = new MinHeap();
        sut.insert(13);
        sut.insert(13);

        int height = sut.getHeight();
        assertEquals(2, height);

    }

    @Test
    public void getPreorderOfTwoElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(13);
        sut.insert(64);

        String preorder = sut.preorder();
        assertEquals("13,64", preorder);

    }

    @Test
    public void getPreorderOfTwoElementsMinHeap2() {

        MinHeap sut = new MinHeap();
        sut.insert(64);
        sut.insert(13);

        String preorder = sut.preorder();
        assertEquals("13,64", preorder);

    }

    @Test
    public void getPreorderOfTwoElementsMinHeap3() {

        MinHeap sut = new MinHeap();
        sut.insert(13);
        sut.insert(13);

        String preorder = sut.preorder();
        assertEquals("13,13", preorder);

    }

    @Test
    public void getPostorderOfTwoElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(13);
        sut.insert(64);

        String postorder = sut.postorder();
        assertEquals("64,13", postorder);

    }

    @Test
    public void getPostorderOfTwoElementsMinHeap2() {

        MinHeap sut = new MinHeap();
        sut.insert(64);
        sut.insert(13);

        String postorder = sut.postorder();
        assertEquals("64,13", postorder);

    }

    @Test
    public void getPostorderOfTwoElementsMinHeap3() {

        MinHeap sut = new MinHeap();
        sut.insert(13);
        sut.insert(13);

        String postorder = sut.postorder();
        assertEquals("13,13", postorder);

    }

    @Test
    public void getHeightOfThreeSameElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(13);
        sut.insert(13);
        sut.insert(13);

        int height = sut.getHeight();
        assertEquals(2, height);
    }

    @Test
    public void getHeightOfThreeDifferentElementsMinHeap() {

        MinHeap sut = new MinHeap();
        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(1);
        values.add(2);
        values.add(3);
        Collections.shuffle(values);

        for(Integer value : values) {
            System.out.println(String.format("Added: %d", value.intValue()));
            sut.insert(value.intValue());
        }

        int height = sut.getHeight();
        assertEquals(2, height);
    }

    @Test
    public void getPreorderOfThreeSameElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(13);
        sut.insert(13);
        sut.insert(13);

        String preorder = sut.preorder();
        assertEquals("13,13,13", preorder);
    }

    @Test
    public void getPreorderOfThreeDifferentElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);

        String preorder = sut.preorder();
        assertEquals("1,2,3", preorder);
    }

    @Test
    public void getPreorderOfThreeDifferentElementsMinHeap2() {

        MinHeap sut = new MinHeap();
        sut.insert(1);
        sut.insert(3);
        sut.insert(2);

        String preorder = sut.preorder();
        assertEquals("1,3,2", preorder);
    }

    @Test
    public void getPreorderOfThreeDifferentElementsMinHeap3() {

        MinHeap sut = new MinHeap();
        sut.insert(2);
        sut.insert(1);
        sut.insert(3);

        String preorder = sut.preorder();
        assertEquals("1,2,3", preorder);
    }

    @Test
    public void getPreorderOfThreeDifferentElementsMinHeap4() {

        MinHeap sut = new MinHeap();
        sut.insert(2);
        sut.insert(3);
        sut.insert(1);

        String preorder = sut.preorder();
        assertEquals("1,3,2", preorder);
    }

    @Test
    public void getPreorderOfThreeDifferentElementsMinHeap5() {

        MinHeap sut = new MinHeap();
        sut.insert(3);
        sut.insert(2);
        sut.insert(1);

        String preorder = sut.preorder();
        assertEquals("1,3,2", preorder);
    }

    @Test
    public void getPreorderOfThreeDifferentElementsMinHeap6() {

        MinHeap sut = new MinHeap();
        sut.insert(3);
        sut.insert(1);
        sut.insert(2);

        String preorder = sut.preorder();
        assertEquals("1,3,2", preorder);
    }

    @Test
    public void getHeightOfFourInOrderElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);
        sut.insert(4);

        int height = sut.getHeight();
        assertEquals(3, height);
    }

    @Test
    public void getHeightOfFiveInOrderElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);
        sut.insert(4);
        sut.insert(5);

        int height = sut.getHeight();
        assertEquals(3, height);
    }

    @Test
    public void getHeightOfSixInOrderElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);
        sut.insert(4);
        sut.insert(5);
        sut.insert(6);

        int height = sut.getHeight();
        assertEquals(3, height);
    }

    @Test
    public void getHeightOfSevenInOrderElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);
        sut.insert(4);
        sut.insert(5);
        sut.insert(6);
        sut.insert(7);

        int height = sut.getHeight();
        assertEquals(4, height);
    }

    @Test
    public void getHeightOfFourReversedElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(4);
        sut.insert(3);
        sut.insert(2);
        sut.insert(1);

        int height = sut.getHeight();
        assertEquals(3, height);
    }

    @Test
    public void getHeightOfFiveReversedElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(5);
        sut.insert(4);
        sut.insert(3);
        sut.insert(2);
        sut.insert(1);

        int height = sut.getHeight();
        assertEquals(3, height);
    }

    @Test
    public void getHeightOfSixReversedElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(6);
        sut.insert(5);
        sut.insert(4);
        sut.insert(3);
        sut.insert(2);
        sut.insert(1);

        int height = sut.getHeight();
        assertEquals(3, height);
    }

    @Test
    public void getHeightOfSevenReversedElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(7);
        sut.insert(6);
        sut.insert(5);
        sut.insert(4);
        sut.insert(3);
        sut.insert(2);
        sut.insert(1);

        int height = sut.getHeight();
        assertEquals(4, height);
    }

    @Test
    public void getPreorderOfSevenInorderElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);
        sut.insert(4);
        sut.insert(5);
        sut.insert(6);
        sut.insert(7);

        String preorder = sut.preorder();
        assertEquals("1,2,4,7,6,3,5", preorder);
    }

    @Test
    public void getPostorderOfSevenInorderElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(1);
        sut.insert(2);
        sut.insert(3);
        sut.insert(4);
        sut.insert(5);
        sut.insert(6);
        sut.insert(7);

        String postorder = sut.postorder();
        assertEquals("7,4,6,2,5,3,1", postorder);
    }

    @Test
    public void getPreorderOfSevenReversedElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(7);
        sut.insert(6);
        sut.insert(5);
        sut.insert(4);
        sut.insert(3);
        sut.insert(2);
        sut.insert(1);

        String preorder = sut.preorder();
        assertEquals("1,2,3,7,5,4,6", preorder);
    }

    @Test
    public void getPostorderOfSevenReversedElementsMinHeap() {

        MinHeap sut = new MinHeap();
        sut.insert(7);
        sut.insert(6);
        sut.insert(5);
        sut.insert(4);
        sut.insert(3);
        sut.insert(2);
        sut.insert(1);

        String postorder = sut.postorder();
        assertEquals("7,3,5,2,6,4,1", postorder);
    }
}