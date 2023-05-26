package androidx.camera.core.internal.utils;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public class ArrayRingBuffer<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f3928a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayDeque<T> f3929b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f3930c = new Object();

    /* renamed from: d  reason: collision with root package name */
    final RingBuffer$OnRemoveCallback<T> f3931d;

    public ArrayRingBuffer(int i8, RingBuffer$OnRemoveCallback<T> ringBuffer$OnRemoveCallback) {
        this.f3928a = i8;
        this.f3929b = new ArrayDeque<>(i8);
        this.f3931d = ringBuffer$OnRemoveCallback;
    }

    @NonNull
    public T a() {
        T removeLast;
        synchronized (this.f3930c) {
            removeLast = this.f3929b.removeLast();
        }
        return removeLast;
    }

    public void b(@NonNull T t7) {
        T t8;
        synchronized (this.f3930c) {
            if (this.f3929b.size() >= this.f3928a) {
                t8 = a();
            } else {
                t8 = null;
            }
            this.f3929b.addFirst(t7);
        }
        RingBuffer$OnRemoveCallback<T> ringBuffer$OnRemoveCallback = this.f3931d;
        if (ringBuffer$OnRemoveCallback != null && t8 != null) {
            ringBuffer$OnRemoveCallback.a(t8);
        }
    }

    public boolean c() {
        boolean isEmpty;
        synchronized (this.f3930c) {
            isEmpty = this.f3929b.isEmpty();
        }
        return isEmpty;
    }
}
