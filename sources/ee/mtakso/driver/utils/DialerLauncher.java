package ee.mtakso.driver.utils;

import ee.mtakso.driver.service.analytics.event.facade.OrderAnalytics;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialerLauncher.kt */
/* loaded from: classes5.dex */
public final class DialerLauncher {

    /* renamed from: a  reason: collision with root package name */
    private final OrderAnalytics f36306a;

    @Inject
    public DialerLauncher(OrderAnalytics analytics) {
        Intrinsics.f(analytics, "analytics");
        this.f36306a = analytics;
    }
}
