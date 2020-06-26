package test.sort;

public class bubbleSort {
    private static void bubbleSort(int[] data) {

        // 比较的是次数
        for (int i = data.length - 1; i > 0; i--) {
            // 每次比较冒泡的过程(查找最大值的过程)，每次从第一个数据开始，因此j每次都是从零开始。
            //从图解中可以看出，随着比较次数的增多，冒泡的过程逐渐减少，因此i的值是随着比较的次数增多而减少。
            //反推i的初始值为最大，又由于5个数据比较次数为4次，可得出i的初始值为数据个数-1。
            for (int j = 0; j < i; j++) {

                // 数据交换
                if (data[j] > data[j + 1]) {
                    // 交换
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }

            }
        }
    }
}
