package test;

class Main {

    static int num = 0;
    static int state = 0;

    public static void main(String[] args) {
        Main a = new Main();
        Object lock = new Object();


        Thread thread = new Thread(new Runnable1(lock, 0));
        Thread thread1 = new Thread(new Runnable1(lock, 1));
        Thread thread2 = new Thread(new Runnable1(lock, 2));
        thread.start();
        thread1.start();
        thread2.start();
    }

    static class Runnable1 implements Runnable {
        int shouldState = 0;
        Object lock;

        public Runnable1(Object lock, int _state) {
            this.lock = lock;
            shouldState = _state;
        }

        @Override
        public void run() {
            while (num <= 100) {
                synchronized (lock) {
                    if (num <= 100) {
                        if (shouldState == state) {
                            System.out.println(num++ + Thread.currentThread().getName());
                            state = (state + 1) % 3;
                        } else
                            continue;
                    }
                }
            }
        }
    }
}
