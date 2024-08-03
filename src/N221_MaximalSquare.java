public class N221_MaximalSquare implements Solution{

    @Override
    public void test(){

        char[][] testCase = new char[][]{
                {'1','0','1','0'},
                {'1','0','1','1'},
                {'1','0','1','1'},
                {'1','1','1','1'}
        };

        System.out.println(maximalSquare(testCase));
    }

    private int maximalSquare(char[][] matrix) {

        int maxSquare = Integer.MIN_VALUE;

        int[] up = new int[matrix[0].length + 1];
        int prev = 0;
        int upLeft = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){

                prev = up[j + 1];
                if(matrix[i][j] == '1'){

                    int temp = Math.min(Math.min(up[j], up[j + 1]), upLeft) + 1;
                    maxSquare = Math.max(temp, maxSquare);
                    up[j + 1] = temp;
                }
                else {
                    up[j + 1] = 0;
                }
                upLeft = prev;
            }
        }
        return maxSquare * maxSquare;
    }
}
