import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N46_Permutations {


    private int[] TestCase = new int[] { 1, 2, 3 };

    public void test() {

        List<List<Integer>> answer = permute(TestCase);

        System.out.println(Arrays.toString(answer.toArray()));
    }

    private List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        permute2(curr, result, nums);

        return result;
    }

    private void permute2(List<Integer> curr, List<List<Integer>> result, int [] nums) {

        if (curr.size() == nums.length) {

            result.add(new ArrayList<>(curr));
        }
        else {

            for (int num : nums) {
                if (!curr.contains(num)) {

                    curr.add(num);
                    permute2(curr, result, nums);
                    curr.removeLast();
                }
            }
        }
    }
}
