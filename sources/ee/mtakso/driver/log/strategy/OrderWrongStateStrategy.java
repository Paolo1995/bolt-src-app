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

/* compiled from: OrderWrongStateStrategy.kt */
/* loaded from: classes3.dex */
public final class OrderWrongStateStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final LogStorage f21163a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f21164b;

    @Inject
    public OrderWrongStateStrategy(LogStorage logStorage, DriverProvider driverProvider) {
        Intrinsics.f(logStorage, "logStorage");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f21163a = logStorage;
        this.f21164b = driverProvider;
    }

    private final void b(LogEntry logEntry) {
        long currentTimeMillis;
        List<LogEntity> A0;
        int v7;
        LogStorage logStorage = this.f21163a;
        Long h8 = logEntry.h();
        if (h8 != null) {
            currentTimeMillis = h8.longValue();
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        A0 = CollectionsKt___CollectionsKt.A0(logStorage.d("network", currentTimeMillis), 15);
        LogStorage logStorage2 = this.f21163a;
        v7 = CollectionsKt__IterablesKt.v(A0, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (LogEntity logEntity : A0) {
            arrayList.add(new ApplogSync(logEntity.f(), false, 2, null));
        }
        logStorage2.a(arrayList);
    }

    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
        if (this.f21164b.p().d().contains("order_wrong_state") && Intrinsics.a(entry.d(), "network") && entry.c().containsKey("ORDER_IS_IN_WRONG_STATE_FOR_THIS_ACTION")) {
            b(entry);
        }
    }
}
