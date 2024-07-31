import java.util.ArrayList;
import java.util.List;

public class N48_RotateImage implements Solution{

    private List<int [][]> TestCase = new ArrayList<>();

    @Override
    public void test (){

        TestCase.add(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        TestCase.add(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});

        for(int[][] matrix : TestCase){

            rotate(matrix);
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }
    }

    public void rotate (int [][] matrix){

        int length = matrix.length - 1;

        for(int i = 0 ; i < (length + 1)/2 ; i++){

            for(int j = 0; j < length - (i * 2); j++){

                System.out.print("a: " + matrix[i][j + i] + " ");
                System.out.print("b: " + matrix[j + i][length - i] + " ");
                System.out.print("c: " + matrix[length - i][length - j - i] + " ");
                System.out.print("d: " + matrix[length - j - i][i] + " ");
                System.out.println();

                int tmp = matrix[i][j + i];
                matrix[i][j + i] = matrix[length - j - i][i];
                matrix[length - j - i][i] = matrix[length - i][length - j - i];
                matrix[length - i][length - j - i] = matrix[j + i][length - i];
                matrix[j + i][length - i] = tmp;
            }
        }
    }
}
