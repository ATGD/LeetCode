package ext;

import java.util.PriorityQueue;
import java.util.Random;

public class BillinTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 1_000_000_00; i++) {
            queue.offer((int) (1_000_000_00 * new Random().nextFloat()));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.poll());
        }
    }
}
