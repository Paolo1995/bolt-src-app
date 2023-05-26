package ee.mtakso.driver.log;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogWorker.kt */
@Singleton
/* loaded from: classes3.dex */
public final class LogWorker {

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f21032a = Executors.newScheduledThreadPool(1);

    public final void a(Runnable action) {
        Intrinsics.f(action, "action");
        this.f21032a.execute(action);
    }

    public final ScheduledFuture<?> b(Runnable action, long j8) {
        Intrinsics.f(action, "action");
        ScheduledFuture<?> scheduleAtFixedRate = this.f21032a.scheduleAtFixedRate(action, 0L, j8, TimeUnit.SECONDS);
        Intrinsics.e(scheduleAtFixedRate, "scheduler.scheduleAtFixe…tion, 0, period, SECONDS)");
        return scheduleAtFixedRate;
    }
}
