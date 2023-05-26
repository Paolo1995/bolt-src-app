package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForwardingTimeout.kt */
/* loaded from: classes5.dex */
public class ForwardingTimeout extends Timeout {

    /* renamed from: a  reason: collision with root package name */
    private Timeout f52599a;

    public ForwardingTimeout(Timeout delegate) {
        Intrinsics.f(delegate, "delegate");
        this.f52599a = delegate;
    }

    public final Timeout a() {
        return this.f52599a;
    }

    public final ForwardingTimeout b(Timeout delegate) {
        Intrinsics.f(delegate, "delegate");
        this.f52599a = delegate;
        return this;
    }

    @Override // okio.Timeout
    public Timeout clearDeadline() {
        return this.f52599a.clearDeadline();
    }

    @Override // okio.Timeout
    public Timeout clearTimeout() {
        return this.f52599a.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.f52599a.deadlineNanoTime();
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.f52599a.hasDeadline();
    }

    @Override // okio.Timeout
    public void throwIfReached() throws IOException {
        this.f52599a.throwIfReached();
    }

    @Override // okio.Timeout
    public Timeout timeout(long j8, TimeUnit unit) {
        Intrinsics.f(unit, "unit");
        return this.f52599a.timeout(j8, unit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.f52599a.timeoutNanos();
    }

    @Override // okio.Timeout
    public Timeout deadlineNanoTime(long j8) {
        return this.f52599a.deadlineNanoTime(j8);
    }
}
