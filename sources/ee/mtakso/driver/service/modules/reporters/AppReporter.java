package ee.mtakso.driver.service.modules.reporters;

import ee.mtakso.driver.network.client.driver.DriverStatus;
import ee.mtakso.driver.network.client.driver.DriverStatusKt;
import ee.mtakso.driver.network.client.driver.OrderSummary;
import ee.mtakso.driver.network.client.driver.PollingResult;
import ee.mtakso.driver.service.analytics.event.facade.AppStateAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.utils.AppForegroundState;
import eu.bolt.kalev.Kalev;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: AppReporter.kt */
@Singleton
/* loaded from: classes3.dex */
public final class AppReporter implements NotRespondReporter, WrongStateReporter {

    /* renamed from: a  reason: collision with root package name */
    private final TrueTimeProvider f25212a;

    /* renamed from: b  reason: collision with root package name */
    private final AppStateAnalytics f25213b;

    /* renamed from: c  reason: collision with root package name */
    private final SimpleDateFormat f25214c;

    /* renamed from: d  reason: collision with root package name */
    private final ObjectPool<String> f25215d;

    /* renamed from: e  reason: collision with root package name */
    private final ObjectPool<PollingResult> f25216e;

    /* renamed from: f  reason: collision with root package name */
    private final ObjectPool<String> f25217f;

    /* renamed from: g  reason: collision with root package name */
    private final ObjectPool<String> f25218g;

    /* renamed from: h  reason: collision with root package name */
    private Integer f25219h;

    /* renamed from: i  reason: collision with root package name */
    private String f25220i;

    /* renamed from: j  reason: collision with root package name */
    private String f25221j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f25222k;

    /* renamed from: l  reason: collision with root package name */
    private DriverStatus f25223l;

    @Inject
    public AppReporter(TrueTimeProvider trueTimeProvider, AppStateAnalytics analytics) {
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(analytics, "analytics");
        this.f25212a = trueTimeProvider;
        this.f25213b = analytics;
        this.f25214c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        this.f25215d = new ObjectPool<>(3);
        this.f25216e = new ObjectPool<>(3);
        this.f25217f = new ObjectPool<>(3);
        this.f25218g = new ObjectPool<>(3);
    }

    private final String k(TrueTimeProvider trueTimeProvider) {
        String format = this.f25214c.format(new Date(trueTimeProvider.b()));
        Intrinsics.e(format, "dateFormat.format(date)");
        return format;
    }

    private final HashMap<String, Object> l() {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<PollingResult> it = this.f25216e.b().iterator();
        int i8 = 0;
        while (it.hasNext()) {
            int i9 = i8 + 1;
            PollingResult next = it.next();
            hashMap.put("pollingResult_driverState_" + i8, next.c());
            List<OrderSummary> j8 = next.j();
            if (j8 != null) {
                int i10 = 0;
                for (Object obj : j8) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt__CollectionsKt.u();
                    }
                    OrderSummary orderSummary = (OrderSummary) obj;
                    hashMap.put("pollingResult_orderId_" + i8 + "_" + i10, String.valueOf(orderSummary.b().b()));
                    hashMap.put("pollingResult_orderState_" + i8 + "_" + i10, orderSummary.f());
                    i10 = i11;
                }
            }
            i8 = i9;
        }
        hashMap.put("driverStatus", this.f25215d.toString());
        hashMap.put("appRoutingManagerPool", this.f25217f.toString());
        hashMap.put("activeOrderId", this.f25219h);
        return hashMap;
    }

    @Override // ee.mtakso.driver.service.modules.reporters.NotRespondReporter
    public void a() {
        this.f25220i = k(this.f25212a);
    }

    @Override // ee.mtakso.driver.service.modules.reporters.NotRespondReporter
    public void b() {
        this.f25221j = k(this.f25212a);
    }

    @Override // ee.mtakso.driver.service.modules.reporters.NotRespondReporter
    public void c() {
        HashMap<String, Object> l8 = l();
        l8.put("appForegroundState", this.f25218g.toString());
        l8.put("newOrderActivityOpenedTimestamp", this.f25221j);
        l8.put("navigationToNewOrderCallTimestamp", this.f25220i);
        this.f25213b.H3(l8);
    }

    @Override // ee.mtakso.driver.service.modules.reporters.WrongStateReporter
    public void d(Throwable throwable) {
        List d02;
        List C0;
        Object h02;
        Intrinsics.f(throwable, "throwable");
        HashMap<String, Object> l8 = l();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        Intrinsics.e(stackTrace, "throwable.stackTrace");
        d02 = ArraysKt___ArraysKt.d0(stackTrace, 5);
        int i8 = 0;
        for (Object obj : d02) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            StackTraceElement stackTraceElement = (StackTraceElement) obj;
            String className = stackTraceElement.getClassName();
            Intrinsics.e(className, "trace.className");
            C0 = StringsKt__StringsKt.C0(className, new String[]{"."}, false, 0, 6, null);
            h02 = CollectionsKt___CollectionsKt.h0(C0);
            l8.put("trace_" + i8, h02 + ":" + stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber());
            i8 = i9;
        }
        l8.put("drawStateFailReason", throwable.getMessage());
        this.f25213b.K2(l8);
    }

    @Override // ee.mtakso.driver.service.modules.reporters.WrongStateReporter
    public void e() {
        this.f25213b.i1(l());
    }

    @Override // ee.mtakso.driver.service.modules.reporters.NotRespondReporter
    public void f(PollingResult pollingResult) {
        Intrinsics.f(pollingResult, "pollingResult");
        this.f25216e.d(pollingResult);
    }

    @Override // ee.mtakso.driver.service.modules.reporters.WrongStateReporter
    public void g() {
        this.f25213b.q3(l());
    }

    @Override // ee.mtakso.driver.service.modules.reporters.NotRespondReporter
    public void h(AppForegroundState appForegroundState) {
        Intrinsics.f(appForegroundState, "appForegroundState");
        this.f25218g.d(appForegroundState.c());
    }

    public void i(String status) {
        Intrinsics.f(status, "status");
        this.f25215d.d(status);
    }

    public void j(DriverStatus status) {
        boolean z7;
        Intrinsics.f(status, "status");
        if (status == this.f25223l) {
            return;
        }
        if (this.f25222k && DriverStatusKt.a(status)) {
            Kalev.b("Driver went offline by decision");
            this.f25222k = false;
        } else {
            DriverStatus driverStatus = this.f25223l;
            boolean z8 = true;
            if (driverStatus != null && DriverStatusKt.b(driverStatus)) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7 && status == DriverStatus.PENDING) {
                this.f25222k = true;
            } else if (!this.f25222k) {
                DriverStatus driverStatus2 = this.f25223l;
                if (((driverStatus2 == null || !DriverStatusKt.b(driverStatus2)) ? false : false) && DriverStatusKt.a(status)) {
                    Kalev.n("status", status).n("lastDriverStatus", this.f25223l).n("reason", "backend").a("driver put offline");
                    this.f25213b.o2();
                    this.f25222k = false;
                }
            }
        }
        this.f25223l = status;
    }
}
