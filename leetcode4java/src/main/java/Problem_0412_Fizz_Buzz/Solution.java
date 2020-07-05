package Problem_0412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> resultList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                resultList.add("FizzBuzz");
            else if (i % 3 == 0)
                resultList.add("Fizz");
            else if (i % 5 == 0)
                resultList.add("Buzz");
            else
                resultList.add("" + i);
        }
        return resultList;
    }
}

