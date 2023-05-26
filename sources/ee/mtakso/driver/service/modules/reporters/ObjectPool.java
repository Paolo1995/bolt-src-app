package ee.mtakso.driver.service.modules.reporters;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ObjectPool.kt */
/* loaded from: classes3.dex */
public final class ObjectPool<T> implements Iterable<T>, KMappedMarker {

    /* renamed from: f  reason: collision with root package name */
    private final int f25226f;

    /* renamed from: g  reason: collision with root package name */
    private final Deque<T> f25227g = new LinkedList();

    public ObjectPool(int i8) {
        this.f25226f = i8;
    }

    public final synchronized LinkedList<T> b() {
        return new LinkedList<>(this.f25227g);
    }

    public final synchronized void d(T t7) {
        if (this.f25227g.size() >= this.f25226f) {
            this.f25227g.removeLast();
        }
        this.f25227g.addFirst(t7);
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        Iterator<T> it = this.f25227g.iterator();
        Intrinsics.e(it, "queue.iterator()");
        return it;
    }

    public String toString() {
        return this.f25227g.toString();
    }
}
