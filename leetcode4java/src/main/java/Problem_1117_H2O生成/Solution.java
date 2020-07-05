package Problem_1117_H2O生成;

class H2O {

    int hNum = 0;
    final Object lock = new Object();

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (lock) {
            while (hNum == 2) {
                lock.notify();
                lock.wait();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hNum++;
            lock.notify();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (lock) {
            while (hNum < 2) {
                lock.notify();
                lock.wait();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            hNum = 0;
            lock.notify();
        }
    }
}

class Test {
    public static void main(String[] args) {

        H2O h2O = new H2O();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    h2O.hydrogen(() -> {
                        System.out.print("H");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    h2O.oxygen(() -> {
                        System.out.print("O");
                        System.out.println();
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}