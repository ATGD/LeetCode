package Problem_1226_哲学家进餐;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    List<Semaphore> semList = new ArrayList<>();

    public DiningPhilosophers() {
        semList.addAll(
                Arrays.asList(
                        new Semaphore(1), new Semaphore(1),
                        new Semaphore(1), new Semaphore(1),
                        new Semaphore(1))
        );
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while (true) {
            int rightIndex = (philosopher + 1) % semList.size();
            final Semaphore leftFork = semList.get(philosopher);
            final Semaphore rightFork = semList.get(rightIndex);
            if (leftFork.tryAcquire()) {
                if (rightFork.tryAcquire()) {
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    leftFork.release();
                    putRightFork.run();
                    rightFork.release();
                    break;
                } else {
                    leftFork.release();
                    Thread.sleep(0);
                }
            } else {
                Thread.sleep(0);
            }
        }
    }
}