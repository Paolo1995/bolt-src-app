package eu.bolt.driver.core.time;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* compiled from: AnchoredTimeSource.kt */
/* loaded from: classes5.dex */
public final class AnchoredTimeSource {

    /* renamed from: a  reason: collision with root package name */
    private final long f40988a;

    public AnchoredTimeSource(long j8) {
        this.f40988a = j8 - SystemClock.elapsedRealtime();
    }

    public final long a() {
        return SystemClock.elapsedRealtime() + this.f40988a;
    }

    public final long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }
}
