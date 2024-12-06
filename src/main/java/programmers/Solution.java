package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        List<String> numbersList = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> {
                            if ((a + b).compareTo(b + a) < 0) {
                                return -1;
                            } else if((a + b).compareTo(b + a)==0){
                                return 0;
                            }
                            else return 1;
                        }
                )
                .collect(Collectors.toList());

        if (numbersList.get(0).equals("0")){
            return "0";
        }

        return String.join("", numbersList);
    }
}
