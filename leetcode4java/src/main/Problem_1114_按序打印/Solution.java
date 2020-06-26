package Problem_1114_按序打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo {

    Lock lock = new ReentrantLock();
    Condition conditionOne = lock.newCondition();
    Condition conditionTwo = lock.newCondition();
    Condition conditionThree = lock.newCondition();
    int num = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            while (num != 1)
                conditionOne.await();
            lock.lock();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            conditionTwo.signal();
        } finally {
            try {
                lock.unlock();
            } catch (Exception ignore) {
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            lock.lock();
            while (num != 2)
                conditionTwo.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            conditionThree.signal();
        } finally {
            try {
                lock.unlock();
            } catch (Exception ignore) {
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            lock.lock();
            while (num != 3)
                conditionThree.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            conditionOne.signal();
        } finally {
            try {
                lock.unlock();
            } catch (Exception ignore) {
            }
        }
    }
}
