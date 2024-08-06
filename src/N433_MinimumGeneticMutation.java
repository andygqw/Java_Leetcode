import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class N433_MinimumGeneticMutation implements Solution{

    @Override
    public void test(){

    }

    private int minMutation(String startGene, String endGene, String[] bank){
        Character[] gene = {'A', 'C', 'G', 'T'};

        Deque<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.add(startGene);
        set.add(startGene);

        int count = 0;

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i < size; i++){

                String str = queue.poll();

                for(int j = 0; j < 8; j++){
                    for(var c : gene){

                        String newStr = modifyCharacter(str, j, c);
                        if(!set.contains(newStr)){

                            for(var s : bank){
                                if(s.compareTo(newStr) == 0){

                                    if(s.compareTo(endGene) == 0){

                                        return ++count;
                                    }
                                    queue.add(newStr);
                                    set.add(newStr);
                                }
                            }
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private static String modifyCharacter(String str, int index, char newChar) {
        StringBuilder stringBuilder = new StringBuilder(str);

        stringBuilder.setCharAt(index, newChar);

        return stringBuilder.toString();
    }
}
