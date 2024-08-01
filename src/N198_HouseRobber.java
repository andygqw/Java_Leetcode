import java.sql.SQLOutput;
import java.util.Map;
import java.util.HashMap;

public class N198_HouseRobber implements Solution{


    @Override
    public void test(){

        int [] testCase  = {2,7,9,3,1};


        System.out.println(rob(testCase));
    }


    private int rob(int[] nums) {

        int len = nums.length;

        int gap1 = 0;
        int gap0 = nums[0];

        for(int i = 1; i < len; i++){

            int tmp = gap1;
            gap1 = gap0;
            gap0 = Math.max(gap0, nums[i] + tmp);
        }
        return gap0;
    }
}