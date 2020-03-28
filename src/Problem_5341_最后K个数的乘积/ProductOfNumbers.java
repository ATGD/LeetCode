package Problem_5341_最后K个数的乘积;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {

    List<Integer> list = new ArrayList<>(40000);

    public ProductOfNumbers() {

    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int result = 1;
        for (int i = list.size() - 1; i >= list.size() - k; i--) {
            result *= list.get(i);
        }
        return result;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */