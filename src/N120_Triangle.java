import java.util.*;

public class N120_Triangle implements Solution{

    @Override
    public void test (){

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));

        System.out.println(minimumTotal(triangle));
    }

    private int minimumTotal(List<List<Integer>> triangle) {

        if(triangle.size() == 1){

            return triangle.getFirst().getFirst();
        }

        int rows = triangle.size();

        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < triangle.get(rows - 1).size(); i++){
            list.add(0);
        }

        for(int i = rows - 1; i > 0 ; i--){
            int row = triangle.get(i).size();
            List<Integer> curr = new LinkedList<>();
            for(int j = 0; j < row - 1; j++){

                int a = triangle.get(i).get(j) + list.get(j);
                int b = triangle.get(i).get(j + 1) + list.get(j + 1);

                curr.add(Math.min(a,b));
            }
            list = curr;
        }

        return triangle.getFirst().getFirst() + list.getFirst();
    }
}
