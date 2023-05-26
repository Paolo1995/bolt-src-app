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
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DriverWrongStateStrategy.kt */
/* loaded from: classes3.dex */
public final class DriverWrongStateStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final LogStorage f21151a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f21152b;

    @Inject
    public DriverWrongStateStrategy(LogStorage logStorage, DriverProvider driverProvider) {
        Intrinsics.f(logStorage, "logStorage");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f21151a = logStorage;
        this.f21152b = driverProvider;
    }

    private final void b(LogEntry logEntry) {
        long currentTimeMillis;
        List<LogEntity> A0;
        int v7;
        LogStorage logStorage = this.f21151a;
        Long h8 = logEntry.h();
        if (h8 != null) {
            currentTimeMillis = h8.longValue();
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        A0 = CollectionsKt___CollectionsKt.A0(logStorage.d("network", currentTimeMillis), 15);
        LogStorage logStorage2 = this.f21151a;
        v7 = CollectionsKt__IterablesKt.v(A0, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (LogEntity logEntity : A0) {
            arrayList.add(new ApplogSync(logEntity.f(), false, 2, null));
        }
        logStorage2.a(arrayList);
    }

    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
        if (this.f21152b.p().d().contains("driver_wrong_state") && Intrinsics.a(entry.d(), "network") && entry.c().containsKey("DRIVER_IS_IN_WRONG_STATE_FOR_THIS_ACTION")) {
            b(entry);
        }
    }
}
