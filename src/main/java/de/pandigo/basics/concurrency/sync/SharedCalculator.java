package de.pandigo.basics.concurrency.sync;

public class SharedCalculator {

    private int sum = 0;
    private static int staticSum = 0;


    public void addOneUnSynchronized() {
        setSum(getSum()+1);
    }

    public synchronized void addOneSynchronized() {
        setSum(getSum()+1);
    }

    public synchronized static void addOneSynchronizedStatic() {
        setStaticSum(getStaticSum()+1);
    }

    public void addOneSynchronizedPartially() {
        //Notice, that we passed a parameter this to the synchronized block. This is the monitor object,
        // the code inside the block get synchronized on the monitor object. Simply put, only one thread
        // per monitor object can execute inside that block of code.
        synchronized (this) {
            setSum(getSum() + 1);
        }
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    public static int getStaticSum() {
        return staticSum;
    }

    public static void setStaticSum(int staticSum) {
        SharedCalculator.staticSum = staticSum;
    }
}
