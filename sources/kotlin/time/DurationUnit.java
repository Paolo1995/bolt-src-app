package kotlin.time;

import java.util.concurrent.TimeUnit;

/* compiled from: DurationUnitJvm.kt */
/* loaded from: classes5.dex */
public enum DurationUnit {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);
    

    /* renamed from: f  reason: collision with root package name */
    private final TimeUnit f51191f;

    DurationUnit(TimeUnit timeUnit) {
        this.f51191f = timeUnit;
    }

    public final TimeUnit c() {
        return this.f51191f;
    }
}
