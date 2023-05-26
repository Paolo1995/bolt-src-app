package ee.mtakso.driver.log.strategy.memory;

import android.annotation.SuppressLint;
import ee.mtakso.driver.log.applog.ApplogUploader;
import ee.mtakso.driver.log.strategy.memory.OrderStateStrategy;
import ee.mtakso.driver.network.client.applog.ApplogEntry;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalevipoeg;
import eu.bolt.kalev.LogEntry;
import io.reactivex.Single;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OrderStateStrategy.kt */
@Singleton
/* loaded from: classes3.dex */
public final class OrderStateStrategy implements Kalevipoeg {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f21171e = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private static final List<String> f21172f;

    /* renamed from: a  reason: collision with root package name */
    private final ApplogUploader f21173a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverProvider f21174b;

    /* renamed from: c  reason: collision with root package name */
    private final List<ApplogEntry> f21175c;

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantLock f21176d;

    /* compiled from: OrderStateStrategy.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        List<String> n8;
        n8 = CollectionsKt__CollectionsKt.n("/orderDriver/v1/getActiveOrder/", "/orderDriver/v1/acceptOrder/", "/orderDriver/v1/rejectOrder/");
        f21172f = n8;
    }

    @Inject
    public OrderStateStrategy(ApplogUploader applogUploader, DriverProvider driverProvider) {
        Intrinsics.f(applogUploader, "applogUploader");
        Intrinsics.f(driverProvider, "driverProvider");
        this.f21173a = applogUploader;
        this.f21174b = driverProvider;
        this.f21175c = new ArrayList();
        this.f21176d = new ReentrantLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean e(OrderStateStrategy this$0) {
        Intrinsics.f(this$0, "this$0");
        return Boolean.valueOf(this$0.f21173a.c(this$0.f21175c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(OrderStateStrategy this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.f21175c.clear();
        this$0.f21176d.unlock();
    }

    private final void h(LogEntry logEntry) {
        int b8;
        Map n8;
        long j8;
        DriverConfig d8 = this.f21174b.d();
        String str = (d8 == null || (str = Long.valueOf(d8.t()).toString()) == null) ? "driverAnon" : "driverAnon";
        List<ApplogEntry> list = this.f21175c;
        Map<String, Object> c8 = logEntry.c();
        b8 = MapsKt__MapsJVMKt.b(c8.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(b8);
        Iterator<T> it = c8.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        n8 = MapsKt__MapsKt.n(linkedHashMap, TuplesKt.a("driverId", str));
        String a8 = ApplogUploader.f21057e.a(logEntry.e());
        String d9 = logEntry.d();
        Long h8 = logEntry.h();
        if (h8 != null) {
            j8 = h8.longValue();
        } else {
            j8 = 0;
        }
        list.add(new ApplogEntry(n8, a8, d9, j8));
    }

    @Override // eu.bolt.kalev.Kalevipoeg
    public void a(LogEntry entry) {
        boolean P;
        Intrinsics.f(entry, "entry");
        if (this.f21176d.isLocked()) {
            return;
        }
        if (Intrinsics.a(entry.f(), "order_track")) {
            h(entry);
        }
        if (Intrinsics.a(entry.d(), "network")) {
            P = CollectionsKt___CollectionsKt.P(f21172f, entry.c().get("path"));
            if (P) {
                h(entry);
            }
        }
    }

    @SuppressLint({"CheckResult"})
    public final void d() {
        this.f21176d.lock();
        Single u7 = Single.u(new Callable() { // from class: u1.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean e8;
                e8 = OrderStateStrategy.e(OrderStateStrategy.this);
                return e8;
            }
        });
        Intrinsics.e(u7, "fromCallable { applogUpl…der.uploadEntries(logs) }");
        SingleExtKt.d(u7).j(new Action() { // from class: u1.b
            @Override // io.reactivex.functions.Action
            public final void run() {
                OrderStateStrategy.f(OrderStateStrategy.this);
            }
        }).G();
    }

    public final void g() {
        ReentrantLock reentrantLock = this.f21176d;
        reentrantLock.lock();
        try {
            this.f21175c.clear();
            Unit unit = Unit.f50853a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
