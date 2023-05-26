package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f49638f = new AtomicReference<>();

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f49639g = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {

        /* renamed from: f  reason: collision with root package name */
        private E f49640f;

        LinkedQueueNode() {
        }

        public E a() {
            E b8 = b();
            e(null);
            return b8;
        }

        public E b() {
            return this.f49640f;
        }

        public LinkedQueueNode<E> c() {
            return get();
        }

        public void d(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void e(E e8) {
            this.f49640f = e8;
        }

        LinkedQueueNode(E e8) {
            e(e8);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        e(linkedQueueNode);
        f(linkedQueueNode);
    }

    LinkedQueueNode<T> b() {
        return this.f49639g.get();
    }

    LinkedQueueNode<T> c() {
        return this.f49639g.get();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    LinkedQueueNode<T> d() {
        return this.f49638f.get();
    }

    void e(LinkedQueueNode<T> linkedQueueNode) {
        this.f49639g.lazySet(linkedQueueNode);
    }

    LinkedQueueNode<T> f(LinkedQueueNode<T> linkedQueueNode) {
        return this.f49638f.getAndSet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (c() == d()) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t7) {
        if (t7 != null) {
            LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t7);
            f(linkedQueueNode).d(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public T poll() {
        LinkedQueueNode<T> c8;
        LinkedQueueNode<T> b8 = b();
        LinkedQueueNode<T> c9 = b8.c();
        if (c9 != null) {
            T a8 = c9.a();
            e(c9);
            return a8;
        } else if (b8 != d()) {
            do {
                c8 = b8.c();
            } while (c8 == null);
            T a9 = c8.a();
            e(c8);
            return a9;
        } else {
            return null;
        }
    }
}
