import java.util.HashMap;
import java.util.Map;

class Solution {

    public static boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, int[]> tracker = new HashMap<Integer, int[]>();

        for(int i = 0; i < pieces.length; i++) {
            tracker.put(pieces[i][0], pieces[i]);
        }

        int arrIndex = 0;
        while(arrIndex < arr.length) {

            int currentIndex = arr[arrIndex];
            if(!tracker.containsKey(currentIndex)) {
                return false;
            }

            for(int j = 0; j < tracker.get(currentIndex).length; j++) {

                if(tracker.get(currentIndex)[j] != arr[arrIndex]) {
                    return false;
                }

                arrIndex++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Testing");

        int[] arr = new int[]{12, 34, 56, 78, 90};

        int[] piece1 = new int[]{56, 78, 90};
        int[] piece2 = new int[]{12, 34};
        int[][] pieces = new int[][]{piece1, piece2};

        if(canFormArray(arr, pieces)) {
            System.out.println("Passed!");
        }
        else {
            System.out.println("Failed!");
        }
    }
}