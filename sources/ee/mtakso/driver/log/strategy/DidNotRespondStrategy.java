package ee.mtakso.driver.log.strategy;

import ee.mtakso.driver.log.storage.LogStorage;
import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.kalev.LogEntry;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DidNotRespondStrategy.kt */
/* loaded from: classes3.dex */
public final class DidNotRespondStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final LogStorage f21143a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f21144b;

    @Inject
    public DidNotRespondStrategy(LogStorage logStorage, DriverProvider driverProvider) {
        Intrinsics.f(logStorage, "logStorage");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f21143a = logStorage;
        this.f21144b = driverProvider;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0053 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(java.lang.String r11) {
        /*
            r10 = this;
            ee.mtakso.driver.param.DriverProvider r0 = r10.f21144b
            ee.mtakso.driver.param.DriverFeatures r0 = r0.p()
            java.util.Set r0 = r0.d()
            java.lang.String r1 = "did_not_respond"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L13
            return
        L13:
            ee.mtakso.driver.log.storage.LogStorage r0 = r10.f21143a
            java.lang.String r1 = "order state"
            java.util.List r0 = r0.f(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L24:
            boolean r2 = r0.hasNext()
            r3 = 0
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L42
            java.lang.Object r2 = r0.next()
            r6 = r2
            ee.mtakso.driver.log.storage.LogEntity r6 = (ee.mtakso.driver.log.storage.LogEntity) r6
            java.lang.String r6 = r6.a()
            boolean r3 = kotlin.text.StringsKt.Q(r6, r11, r5, r4, r3)
            if (r3 == 0) goto L24
            r1.add(r2)
            goto L24
        L42:
            ee.mtakso.driver.log.storage.LogStorage r0 = r10.f21143a
            java.lang.String r2 = "network"
            java.util.List r0 = r0.c(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L53:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L7f
            java.lang.Object r6 = r0.next()
            r7 = r6
            ee.mtakso.driver.log.storage.LogEntity r7 = (ee.mtakso.driver.log.storage.LogEntity) r7
            java.lang.String r8 = r7.a()
            java.lang.String r9 = "getActiveOrder"
            boolean r8 = kotlin.text.StringsKt.Q(r8, r9, r5, r4, r3)
            if (r8 == 0) goto L78
            java.lang.String r7 = r7.a()
            boolean r7 = kotlin.text.StringsKt.Q(r7, r11, r5, r4, r3)
            if (r7 == 0) goto L78
            r7 = 1
            goto L79
        L78:
            r7 = 0
        L79:
            if (r7 == 0) goto L53
            r2.add(r6)
            goto L53
        L7f:
            ee.mtakso.driver.log.storage.LogStorage r11 = r10.f21143a
            java.util.List r0 = kotlin.collections.CollectionsKt.n0(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.v(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L94:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lb1
            java.lang.Object r2 = r0.next()
            ee.mtakso.driver.log.storage.LogEntity r2 = (ee.mtakso.driver.log.storage.LogEntity) r2
            ee.mtakso.driver.log.storage.ApplogSync r9 = new ee.mtakso.driver.log.storage.ApplogSync
            long r4 = r2.f()
            r6 = 0
            r7 = 2
            r8 = 0
            r3 = r9
            r3.<init>(r4, r6, r7, r8)
            r1.add(r9)
            goto L94
        Lb1:
            r11.a(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.log.strategy.DidNotRespondStrategy.b(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void c(java.lang.String r11) {
        /*
            r10 = this;
            ee.mtakso.driver.param.DriverProvider r0 = r10.f21144b
            ee.mtakso.driver.param.DriverFeatures r0 = r0.p()
            boolean r0 = r0.l()
            if (r0 != 0) goto Ld
            return
        Ld:
            ee.mtakso.driver.log.storage.LogStorage r0 = r10.f21143a
            java.lang.String r1 = "order state"
            java.util.List r0 = r0.h(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r2 = r0.hasNext()
            r3 = 0
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L3c
            java.lang.Object r2 = r0.next()
            r6 = r2
            ee.mtakso.driver.log.storage.LogEntity r6 = (ee.mtakso.driver.log.storage.LogEntity) r6
            java.lang.String r6 = r6.a()
            boolean r3 = kotlin.text.StringsKt.Q(r6, r11, r5, r4, r3)
            if (r3 == 0) goto L1e
            r1.add(r2)
            goto L1e
        L3c:
            ee.mtakso.driver.log.storage.LogStorage r0 = r10.f21143a
            java.lang.String r2 = "network"
            java.util.List r0 = r0.e(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L4d:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L79
            java.lang.Object r6 = r0.next()
            r7 = r6
            ee.mtakso.driver.log.storage.LogEntity r7 = (ee.mtakso.driver.log.storage.LogEntity) r7
            java.lang.String r8 = r7.a()
            java.lang.String r9 = "getActiveOrder"
            boolean r8 = kotlin.text.StringsKt.Q(r8, r9, r5, r4, r3)
            if (r8 == 0) goto L72
            java.lang.String r7 = r7.a()
            boolean r7 = kotlin.text.StringsKt.Q(r7, r11, r5, r4, r3)
            if (r7 == 0) goto L72
            r7 = 1
            goto L73
        L72:
            r7 = 0
        L73:
            if (r7 == 0) goto L4d
            r2.add(r6)
            goto L4d
        L79:
            ee.mtakso.driver.log.storage.LogStorage r11 = r10.f21143a
            java.util.List r0 = kotlin.collections.CollectionsKt.n0(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.v(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L8e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lab
            java.lang.Object r2 = r0.next()
            ee.mtakso.driver.log.storage.LogEntity r2 = (ee.mtakso.driver.log.storage.LogEntity) r2
            ee.mtakso.driver.log.storage.BigQuerySync r9 = new ee.mtakso.driver.log.storage.BigQuerySync
            long r4 = r2.f()
            r6 = 0
            r7 = 2
            r8 = 0
            r3 = r9
            r3.<init>(r4, r6, r7, r8)
            r1.add(r9)
            goto L8e
        Lab:
            r11.b(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.log.strategy.DidNotRespondStrategy.c(java.lang.String):void");
    }

    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
        if (Intrinsics.a(entry.d(), "Driver did not respond")) {
            String valueOf = String.valueOf(entry.c().get("order_id"));
            b(valueOf);
            c(valueOf);
        }
    }
}
