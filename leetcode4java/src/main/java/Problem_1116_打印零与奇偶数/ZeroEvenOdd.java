package Problem_1116_打印零与奇偶数;

class ZeroEvenOdd {
    public int n;
    public float start = 0.5f;

    public ZeroEvenOdd(int n){
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (start > n) break;
                if (start % 1 > 0) {
                    printNumber.accept(0);
                    start += 0.5f;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (start > n) break;
                if (start % 1  == 0 && ((int) start & 1) == 0){
                    printNumber.accept((int) start);
                    start += 0.5f;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (start > n) break;
                if (start % 1  == 0 && ((int) start & 1) == 1){
                    printNumber.accept((int) start);
                    start += 0.5f;
                    this.notifyAll();
                }else{
                    this.wait();
                }
            }
        }
    }
}

class IntConsumer {
    void accept(int num) {
        System.out.print(num);
    }
}

class Test {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(20);
        IntConsumer intConsumer = new IntConsumer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(intConsumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}