package Problem_0313_超级丑数;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Node tile = new Node(1);
        Node[] primesIndexs = new Node[primes.length];
        for (int i = 0; i < primesIndexs.length; i++) {
            primesIndexs[i] = tile;
        }
        int uglyCount = 1;
        for (; uglyCount < n; ) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < primesIndexs.length; i++) {
                int thisUglyNum = primes[i] * primesIndexs[i].val;
                if (thisUglyNum < min) {
                    min = thisUglyNum;
                    minIndex = i;
                }
            }
            if (min > tile.val) {
                tile.next = new Node(min);
                tile = tile.next;
                uglyCount++;
            }
            if (primesIndexs[minIndex].next != null) {
                primesIndexs[minIndex] = primesIndexs[minIndex].next;
            }
        }
        return tile.val;
    }

}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class Test {
    public static void main(String[] args) {
        int i = new Solution().nthSuperUglyNumber(10, new int[]{2, 7, 13, 19});
        System.out.println(i);
    }
}

