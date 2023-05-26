package eu.bolt.android.engine.html.span.timer;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimerSpan.kt */
/* loaded from: classes5.dex */
public final class TimerSpan implements TimerInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    private final TimerData f36913a;

    public TimerSpan(TimerData data) {
        Intrinsics.f(data, "data");
        this.f36913a = data;
    }

    @Override // eu.bolt.android.engine.html.span.timer.TimerInfoProvider
    public boolean a(long j8) {
        if (this.f36913a.f(j8) != 0) {
            return true;
        }
        return false;
    }
}
