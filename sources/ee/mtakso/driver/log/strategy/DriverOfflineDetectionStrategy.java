package ee.mtakso.driver.log.strategy;

import ee.mtakso.driver.log.storage.ApplogSync;
import ee.mtakso.driver.log.storage.LogEntity;
import ee.mtakso.driver.log.storage.LogStorage;
import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.kalev.LogEntry;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverOfflineDetectionStrategy.kt */
/* loaded from: classes3.dex */
public final class DriverOfflineDetectionStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final LogStorage f21147a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f21148b;

    @Inject
    public DriverOfflineDetectionStrategy(LogStorage logStorage, DriverProvider driverProvider) {
        Intrinsics.f(logStorage, "logStorage");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f21147a = logStorage;
        this.f21148b = driverProvider;
    }

    private final void b() {
        int v7;
        List<LogEntity> c8 = this.f21147a.c("driver put offline");
        LogStorage logStorage = this.f21147a;
        v7 = CollectionsKt__IterablesKt.v(c8, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (LogEntity logEntity : c8) {
            arrayList.add(new ApplogSync(logEntity.f(), false, 2, null));
        }
        logStorage.a(arrayList);
    }

    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
        if (this.f21148b.p().d().contains("driver_offline") && Intrinsics.a(entry.d(), "driver put offline")) {
            b();
        }
    }
}
