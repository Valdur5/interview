## methods

* void lock() – acquire the lock if it’s available; if the lock isn’t available a thread gets blocked until the lock is released
* void lockInterruptibly() – this is similar to the lock(), but it allows the blocked thread to be interrupted and resume the execution through a thrown java.lang.InterruptedException
* boolean tryLock() – this is a non-blocking version of lock() method; it attempts to acquire the lock immediately, return true if locking succeeds
* boolean tryLock(long timeout, TimeUnit timeUnit) – this is similar to tryLock(), except it waits up the given timeout before giving up trying to acquire the Lock
* void unlock() – unlocks the Lock instance

## unlocked
A locked instance should always be unlocked to avoid deadlock condition. A recommended code block to use the lock should contain a try/catch and finally block:

Lock lock = ...; 
lock.lock();
try {
    // access to the shared resource
} finally {
    lock.unlock();
}

## ReadWriteLock
In addition to the Lock interface, we have a ReadWriteLock interface which maintains a pair of locks, one for read-only operations, and one for the write operation. The read lock may be simultaneously held by multiple threads as long as there is no write.

ReadWriteLock declares methods to acquire read or write locks:

Lock readLock() – returns the lock that’s used for reading
Lock writeLock() – returns the lock that’s used for writing