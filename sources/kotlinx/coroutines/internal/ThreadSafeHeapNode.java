package kotlinx.coroutines.internal;

/* compiled from: ThreadSafeHeap.kt */
/* loaded from: classes5.dex */
public interface ThreadSafeHeapNode {
    void a(ThreadSafeHeap<?> threadSafeHeap);

    ThreadSafeHeap<?> c();

    int getIndex();

    void setIndex(int i8);
}
