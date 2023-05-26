package ee.mtakso.driver.log.strategy;

import ee.mtakso.driver.param.DriverProvider;
import eu.bolt.kalev.LogEntry;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositeWatcher.kt */
/* loaded from: classes3.dex */
public final class CompositeWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f21125a;

    /* renamed from: b  reason: collision with root package name */
    private final DidNotRespondStrategy f21126b;

    /* renamed from: c  reason: collision with root package name */
    private final OrderStateStrategy f21127c;

    /* renamed from: d  reason: collision with root package name */
    private final DriverWrongStateStrategy f21128d;

    /* renamed from: e  reason: collision with root package name */
    private final OrderWrongStateStrategy f21129e;

    /* renamed from: f  reason: collision with root package name */
    private final LocationStrategy f21130f;

    /* renamed from: g  reason: collision with root package name */
    private final ActivityLifecycleStrategy f21131g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverOfflineDetectionStrategy f21132h;

    /* renamed from: i  reason: collision with root package name */
    private final WebViewStrategy f21133i;

    @Inject
    public CompositeWatcher(DriverProvider driverProvider, DidNotRespondStrategy didNotRespondStrategy, OrderStateStrategy orderStateStrategy, DriverWrongStateStrategy driverWrongStateStrategy, OrderWrongStateStrategy orderWrongStateStrategy, LocationStrategy locationStrategy, ActivityLifecycleStrategy activityLifecycleStrategy, DriverOfflineDetectionStrategy driverOfflineDetectionStrategy, WebViewStrategy webViewStrategy) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(didNotRespondStrategy, "didNotRespondStrategy");
        Intrinsics.f(orderStateStrategy, "orderStateStrategy");
        Intrinsics.f(driverWrongStateStrategy, "driverWrongStateStrategy");
        Intrinsics.f(orderWrongStateStrategy, "orderWrongStateStrategy");
        Intrinsics.f(locationStrategy, "locationStrategy");
        Intrinsics.f(activityLifecycleStrategy, "activityLifecycleStrategy");
        Intrinsics.f(driverOfflineDetectionStrategy, "driverOfflineDetectionStrategy");
        Intrinsics.f(webViewStrategy, "webViewStrategy");
        this.f21125a = driverProvider;
        this.f21126b = didNotRespondStrategy;
        this.f21127c = orderStateStrategy;
        this.f21128d = driverWrongStateStrategy;
        this.f21129e = orderWrongStateStrategy;
        this.f21130f = locationStrategy;
        this.f21131g = activityLifecycleStrategy;
        this.f21132h = driverOfflineDetectionStrategy;
        this.f21133i = webViewStrategy;
    }

    public void a(LogEntry entry) {
        Intrinsics.f(entry, "entry");
        if (this.f21125a.d() == null) {
            return;
        }
        this.f21126b.a(entry);
        this.f21127c.b(entry);
        this.f21128d.a(entry);
        this.f21129e.a(entry);
        this.f21130f.b(entry);
        this.f21131g.a(entry);
        this.f21132h.a(entry);
        this.f21133i.a(entry);
    }
}
