package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.Segment;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes5.dex */
public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f51831d = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");

    /* renamed from: c  reason: collision with root package name */
    private final long f51832c;
    private volatile /* synthetic */ int cleanedAndPointers;

    public Segment(long j8, S s7, int i8) {
        super(s7);
        this.f51832c = j8;
        this.cleanedAndPointers = i8 << 16;
    }

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public boolean g() {
        if (this.cleanedAndPointers == n() && !i()) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        if (f51831d.addAndGet(this, -65536) == n() && !i()) {
            return true;
        }
        return false;
    }

    public final long m() {
        return this.f51832c;
    }

    public abstract int n();

    public final void o() {
        if (f51831d.incrementAndGet(this) == n() && !i()) {
            j();
        }
    }

    public final boolean p() {
        int i8;
        boolean z7;
        do {
            i8 = this.cleanedAndPointers;
            if (i8 == n() && !i()) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (!z7) {
                return false;
            }
        } while (!f51831d.compareAndSet(this, i8, 65536 + i8));
        return true;
    }
}
