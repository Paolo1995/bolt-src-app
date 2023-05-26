package ee.mtakso.driver.log.strategy;

import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.log.storage.ApplogSync;
import ee.mtakso.driver.log.storage.LogEntity;
import ee.mtakso.driver.log.storage.LogStorage;
import ee.mtakso.driver.network.client.driver.DriverStatus;
import eu.bolt.kalev.LogEntry;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: LocationStrategy.kt */
/* loaded from: classes3.dex */
public final class LocationStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final LogStorage f21155a;

    /* renamed from: b  reason: collision with root package name */
    private final Features f21156b;

    @Inject
    public LocationStrategy(LogStorage logStorage, Features features) {
        Intrinsics.f(logStorage, "logStorage");
        Intrinsics.f(features, "features");
        this.f21155a = logStorage;
        this.f21156b = features;
    }

    private final boolean a(LogEntity logEntity) {
        boolean Q;
        Q = StringsKt__StringsKt.Q(logEntity.a(), "\\/polling\\/drive", false, 2, null);
        if (!Q) {
            return false;
        }
        return true;
    }

    private final void c(long j8, String str) {
        List A0;
        List n02;
        List<LogEntity> n03;
        int v7;
        List<LogEntity> g8 = this.f21155a.g("location", j8, 15);
        List<LogEntity> d8 = this.f21155a.d("network", j8);
        ArrayList arrayList = new ArrayList();
        for (Object obj : d8) {
            if (a((LogEntity) obj)) {
                arrayList.add(obj);
            }
        }
        A0 = CollectionsKt___CollectionsKt.A0(arrayList, 15);
        List<LogEntity> g9 = this.f21155a.g(str, j8, 1);
        LogStorage logStorage = this.f21155a;
        n02 = CollectionsKt___CollectionsKt.n0(g8, A0);
        n03 = CollectionsKt___CollectionsKt.n0(n02, g9);
        v7 = CollectionsKt__IterablesKt.v(n03, 10);
        ArrayList arrayList2 = new ArrayList(v7);
        for (LogEntity logEntity : n03) {
            arrayList2.add(new ApplogSync(logEntity.f(), false, 2, null));
        }
        logStorage.a(arrayList2);
    }

    public void b(LogEntry entry) {
        long currentTimeMillis;
        long currentTimeMillis2;
        Intrinsics.f(entry, "entry");
        if (!this.f21156b.b(Feature.Type.LOCATION_MONITORING)) {
            return;
        }
        if (Intrinsics.a(entry.f(), "driver state") && entry.c().get("new") == DriverStatus.INACTIVE && entry.c().get("old") != null) {
            Long h8 = entry.h();
            if (h8 != null) {
                currentTimeMillis2 = h8.longValue();
            } else {
                currentTimeMillis2 = System.currentTimeMillis();
            }
            c(currentTimeMillis2, "driver state");
        }
        if (Intrinsics.a(entry.f(), "splash")) {
            Long h9 = entry.h();
            if (h9 != null) {
                currentTimeMillis = h9.longValue();
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            c(currentTimeMillis, "splash");
        }
    }
}
