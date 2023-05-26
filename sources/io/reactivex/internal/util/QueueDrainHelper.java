package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;

/* loaded from: classes5.dex */
public final class QueueDrainHelper {
    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> boolean a(boolean z7, boolean z8, Observer<?> observer, boolean z9, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.d()) {
            simpleQueue.clear();
            disposable.dispose();
            return true;
        } else if (z7) {
            if (z9) {
                if (z8) {
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    Throwable i8 = observableQueueDrain.i();
                    if (i8 != null) {
                        observer.onError(i8);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable i9 = observableQueueDrain.i();
            if (i9 != null) {
                simpleQueue.clear();
                if (disposable != null) {
                    disposable.dispose();
                }
                observer.onError(i9);
                return true;
            } else if (z8) {
                if (disposable != null) {
                    disposable.dispose();
                }
                observer.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static <T> SimpleQueue<T> b(int i8) {
        if (i8 < 0) {
            return new SpscLinkedArrayQueue(-i8);
        }
        return new SpscArrayQueue(i8);
    }

    public static <T, U> void c(SimplePlainQueue<T> simplePlainQueue, Observer<? super U> observer, boolean z7, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        boolean z8;
        int i8 = 1;
        while (!a(observableQueueDrain.c(), simplePlainQueue.isEmpty(), observer, z7, simplePlainQueue, disposable, observableQueueDrain)) {
            while (true) {
                boolean c8 = observableQueueDrain.c();
                T poll = simplePlainQueue.poll();
                if (poll == null) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (a(c8, z8, observer, z7, simplePlainQueue, disposable, observableQueueDrain)) {
                    return;
                }
                if (z8) {
                    i8 = observableQueueDrain.b(-i8);
                    if (i8 == 0) {
                        return;
                    }
                } else {
                    observableQueueDrain.a(observer, poll);
                }
            }
        }
    }
}
