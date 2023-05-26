package ee.mtakso.driver.log.strategy;

import ee.mtakso.driver.log.storage.BigQuerySync;
import ee.mtakso.driver.log.storage.LogEntity;
import ee.mtakso.driver.log.storage.LogStorage;
import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.kalev.LogEntry;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityLifecycleStrategy.kt */
/* loaded from: classes3.dex */
public final class ActivityLifecycleStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final LogStorage f21121a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f21122b;

    @Inject
    public ActivityLifecycleStrategy(LogStorage logStorage, DriverProvider driverProvider) {
        Intrinsics.f(logStorage, "logStorage");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f21121a = logStorage;
        this.f21122b = driverProvider;
    }

    private final void b() {
        int v7;
        if (!this.f21122b.p().l()) {
            return;
        }
        List<LogEntity> e8 = this.f21121a.e("activity lifecycle");
        LogStorage logStorage = this.f21121a;
        v7 = CollectionsKt__IterablesKt.v(e8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (LogEntity logEntity : e8) {
            arrayList.add(new BigQuerySync(logEntity.f(), false, 2, null));
        }
        logStorage.b(arrayList);
    }

    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
        if (Intrinsics.a(entry.d(), "activity lifecycle")) {
            b();
        }
    }
}
