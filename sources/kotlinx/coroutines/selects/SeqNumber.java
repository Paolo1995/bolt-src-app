package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* compiled from: Select.kt */
/* loaded from: classes5.dex */
public final class SeqNumber {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f51992a = AtomicLongFieldUpdater.newUpdater(SeqNumber.class, "number");
    private volatile /* synthetic */ long number = 1;

    public final long a() {
        return f51992a.incrementAndGet(this);
    }
}
