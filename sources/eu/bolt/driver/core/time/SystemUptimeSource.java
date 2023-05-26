package eu.bolt.driver.core.time;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* compiled from: SystemUptimeSource.kt */
/* loaded from: classes5.dex */
public final class SystemUptimeSource {
    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    public final long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }
}
