package de.pandigo.basics.concurrency.sync;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ExecutorsSynchronized {

    @Test
    public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SharedCalculator summation = new SharedCalculator();

        IntStream.range(0, 1000).forEach(count -> service.submit(summation::addOneUnSynchronized));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }

    @Test
    public void givenMultiThread_whenSyncMethod() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SharedCalculator summation = new SharedCalculator();

        IntStream.range(0, 1000).forEach(count -> service.submit(summation::addOneSynchronized));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }

    @Test
    public void givenMultiThread_whenSyncMethodStatic() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        IntStream.range(0, 1000).forEach(count -> service.submit(SharedCalculator::addOneSynchronizedStatic));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, SharedCalculator.getStaticSum());
    }

    @Test
    public void givenMultiThread_whenSyncPartiallyMethod() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SharedCalculator summation = new SharedCalculator();

        IntStream.range(0, 1000).forEach(count -> service.submit(summation::addOneSynchronizedPartially));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }

}
