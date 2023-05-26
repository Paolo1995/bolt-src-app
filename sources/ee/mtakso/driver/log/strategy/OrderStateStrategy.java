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
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: OrderStateStrategy.kt */
/* loaded from: classes3.dex */
public final class OrderStateStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f21159a;

    /* renamed from: b  reason: collision with root package name */
    private final LogStorage f21160b;

    @Inject
    public OrderStateStrategy(DriverProvider driverProvider, LogStorage logStorage) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(logStorage, "logStorage");
        this.f21159a = driverProvider;
        this.f21160b = logStorage;
    }

    private final boolean a(LogEntity logEntity, String str) {
        boolean Q;
        boolean Q2;
        boolean Q3;
        Q = StringsKt__StringsKt.Q(logEntity.a(), str, false, 2, null);
        if (!Q) {
            return false;
        }
        Q2 = StringsKt__StringsKt.Q(logEntity.a(), "\\/polling\\/drive", false, 2, null);
        if (Q2) {
            return false;
        }
        Q3 = StringsKt__StringsKt.Q(logEntity.a(), "\\/tracking\\/v1\\/storeLocations", false, 2, null);
        if (Q3) {
            return false;
        }
        return true;
    }

    private final void c(String str) {
        List<LogEntity> n02;
        int v7;
        boolean Q;
        if (!this.f21159a.p().d().contains("order_state")) {
            return;
        }
        List<LogEntity> f8 = this.f21160b.f("order state");
        ArrayList arrayList = new ArrayList();
        for (Object obj : f8) {
            Q = StringsKt__StringsKt.Q(((LogEntity) obj).a(), str, false, 2, null);
            if (Q) {
                arrayList.add(obj);
            }
        }
        List<LogEntity> c8 = this.f21160b.c("network");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : c8) {
            if (a((LogEntity) obj2, str)) {
                arrayList2.add(obj2);
            }
        }
        LogStorage logStorage = this.f21160b;
        n02 = CollectionsKt___CollectionsKt.n0(arrayList, arrayList2);
        v7 = CollectionsKt__IterablesKt.v(n02, 10);
        ArrayList arrayList3 = new ArrayList(v7);
        for (LogEntity logEntity : n02) {
            arrayList3.add(new ApplogSync(logEntity.f(), false, 2, null));
        }
        logStorage.a(arrayList3);
    }

    public void b(LogEntry entry) {
        boolean y7;
        Intrinsics.f(entry, "entry");
        String valueOf = String.valueOf(entry.c().get("order_id"));
        y7 = StringsKt__StringsJVMKt.y(valueOf);
        if ((!y7) && !Intrinsics.a(valueOf, "null")) {
            c(valueOf);
        }
    }
}
