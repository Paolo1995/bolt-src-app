package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes5.dex */
public final class HalfSerializer {
    private HalfSerializer() {
        throw new IllegalStateException("No instances!");
    }

    public static void a(Observer<?> observer, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b8 = atomicThrowable.b();
            if (b8 != null) {
                observer.onError(b8);
            } else {
                observer.onComplete();
            }
        }
    }

    public static void b(Subscriber<?> subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable b8 = atomicThrowable.b();
            if (b8 != null) {
                subscriber.onError(b8);
            } else {
                subscriber.onComplete();
            }
        }
    }

    public static void c(Observer<?> observer, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.a(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                observer.onError(atomicThrowable.b());
                return;
            }
            return;
        }
        RxJavaPlugins.s(th);
    }

    public static void d(Subscriber<?> subscriber, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.a(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                subscriber.onError(atomicThrowable.b());
                return;
            }
            return;
        }
        RxJavaPlugins.s(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void e(Observer<? super T> observer, T t7, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            observer.onNext(t7);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b8 = atomicThrowable.b();
                if (b8 != null) {
                    observer.onError(b8);
                } else {
                    observer.onComplete();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(Subscriber<? super T> subscriber, T t7, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.onNext(t7);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable b8 = atomicThrowable.b();
                if (b8 != null) {
                    subscriber.onError(b8);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }
}
