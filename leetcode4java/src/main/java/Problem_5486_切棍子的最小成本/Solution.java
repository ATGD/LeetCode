package Problem_5486_切棍子的最小成本;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {

    public int minCost(int n, int[] cuts) {
        if (cuts == null) return 0;
        if (cuts.length <= 1) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int lastIndex = 0;
        for (int i = 0; i < cuts.length; i++) {
            map.put(i, cuts[i] - lastIndex);
            lastIndex = cuts[i];
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.leftEntry.length + o2.rightEntry.length;
            }
        });
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Entry leftEnety = pair.leftEntry;
            Integer leftLeftLength = map.get(leftEnety.cut - leftEnety.length);
            if (leftLeftLength != null) {
                queue.remove(leftLeftLength + leftEnety.length);
            }
        }
        return 0;
    }

    class Pair {
        Entry leftEntry;
        Entry rightEntry;
    }

    class Entry {
        int cut;
        int length;
    }

    class MergeEntry {
        public MergeEntry(int leftIndex, int rightIndex, int leftLength, int rightLength) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.leftLength = leftLength;
            this.rightLength = rightLength;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int leftLength = 0;
        int rightLength = 0;
    }
}