import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class N452_MinimumNumberArrowsBurstBalloons implements Solution{

    @Override
    public void test(){

        int[][] testCase = new int[][] {
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };

        int[][] testCase2 = new int[][]{
                {3, 9},
                {7, 12},
                {3, 8},
                {6, 8},
                {9, 10},
                {2, 9},
                {0, 9},
                {3,9},
                {0,6},
                {2,8}
        };

        int[][] testCase3 = new int[][]{
                {9,12},
                {1,10},
                {4,11},
                {8,12},
                {3,9},
                {6,9},
                {6,7}
        };

        Arrays.sort(testCase3, (a , b) -> {
            int result = Integer.compare(a[0], b[0]);
            if (result == 0) {
                result = Integer.compare(a[1], b[1]);
            }
            return result;
        });

        for (int[] subArray : testCase3) {
            System.out.println(Arrays.toString(subArray));
        }
    }


    private int findMinArrowShots(int[][] points) {

        if(points.length == 1){

            return 1;
        }

        Arrays.sort(points, (a , b) -> {
            int result = Integer.compare(a[0], b[0]);
            if (result == 0) {
                result = Integer.compare(a[1], b[1]);
            }
            return result;
        });

        int[] curr = new int[]{points[0][0], points[0][1]};
        int count = 0;

        for(int[] pair : points){

            if(pair[0] <= curr[1]){

                curr[0] = pair[0];
                if (pair[1] < curr[1]) {

                    curr[1] = pair[1];
                }
            }
            else {

                count++;
                curr = pair;
            }
        }
        return ++count;
    }
}