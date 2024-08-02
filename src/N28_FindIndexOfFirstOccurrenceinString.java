import java.util.Arrays;
import java.util.List;

public class N28_FindIndexOfFirstOccurrenceinString implements Solution{

    @Override
    public void test(){

        List<String> testCase = Arrays.asList("hellow", "helllohello","leleetleet");
        List<String> testCase2 = Arrays.asList("l", "hello","leetleet");

        for(int i = 0; i < testCase.size(); i++){

            System.out.println(strStr(testCase.get(i), testCase2.get(i)));
        }
    }

    private int strStr(String haystack, String needle) {

        return 0;
    }
}