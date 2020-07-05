package Meeting_0040_最小的k个数;

class Solution {
    /*public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : arr) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<Integer> resultList = new ArrayList<>();
        while (!queue.isEmpty()) resultList.add(queue.poll());
        int[] results = new int[resultList.size()];
        for (int i = 0; i < results.length; i++) results[results.length - 1 - i] = resultList.get(i);
        return results;
    }*/

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        else if (arr.length <= k) return arr;

        // 原地不断划分数组
        partitionArray(arr, 0, arr.length - 1, k);
        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = arr[i];
        return res;
    }

    void partitionArray(int[] arr, int lo, int hi, int k) {
        // 做一次 partition 操作
        int m = partition(arr, lo, hi);
        // 此时数组前 m 个数，就是最小的 m 个数
        if (k == m) return;// 正好找到最小的 k(m) 个数
        else if (k < m) partitionArray(arr, lo, m - 1, k);// 最小的 k 个数一定在前 m 个数中，递归划分
        else partitionArray(arr, m + 1, hi, k); // 在右侧数组中寻找最小的 k-m 个数
    }

    // partition 函数和快速排序中相同，具体可参考快速排序相关的资料
    // 代码参考 Sedgewick 的《算法4》
    int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = arr[low];
        while (true) {
            while (arr[++i] < v)
                if (i == high) break;
            while (arr[--j] > v)
                if (j == low) break;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}