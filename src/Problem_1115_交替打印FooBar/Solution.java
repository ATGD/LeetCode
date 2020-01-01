package Problem_1115_交替打印FooBar;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    private int n;
    private  Object lock = new Object();
    private boolean fooRun=true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(lock){
                if(!fooRun){
                    lock.wait();
                }
                fooRun =false;
                printFoo.run();
                lock.notify();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(lock){
                if(fooRun){
                    lock.wait();
                }
                fooRun =true;
                printBar.run();
                lock.notify();

            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(1000);
    }
}
