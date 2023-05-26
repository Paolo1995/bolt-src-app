package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Semaphore.kt */
/* loaded from: classes5.dex */
public final class SemaphoreSegment extends Segment<SemaphoreSegment> {

    /* renamed from: e  reason: collision with root package name */
    /* synthetic */ AtomicReferenceArray f52029e;

    public SemaphoreSegment(long j8, SemaphoreSegment semaphoreSegment, int i8) {
        super(j8, semaphoreSegment, i8);
        int i9;
        i9 = SemaphoreKt.f52028f;
        this.f52029e = new AtomicReferenceArray(i9);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int n() {
        int i8;
        i8 = SemaphoreKt.f52028f;
        return i8;
    }

    public final void q(int i8) {
        Symbol symbol;
        symbol = SemaphoreKt.f52027e;
        this.f52029e.set(i8, symbol);
        o();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + m() + ", hashCode=" + hashCode() + ']';
    }
}
