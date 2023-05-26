package ee.mtakso.driver.ui.interactor.network_usage;

import ee.mtakso.driver.network.usage.NetworkUsage;
import ee.mtakso.driver.network.usage.NetworkUsageManager;
import ee.mtakso.driver.network.usage.NetworkUsageUpload;
import ee.mtakso.driver.param.DeviceSettings;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.AppPerformanceAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkUsageUploadInteractor.kt */
/* loaded from: classes3.dex */
public final class NetworkUsageUploadInteractor {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f26681f = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DriverProvider f26682a;

    /* renamed from: b  reason: collision with root package name */
    private final DeviceSettings f26683b;

    /* renamed from: c  reason: collision with root package name */
    private final AppPerformanceAnalytics f26684c;

    /* renamed from: d  reason: collision with root package name */
    private final NetworkUsageManager f26685d;

    /* renamed from: e  reason: collision with root package name */
    private final TrueTimeProvider f26686e;

    /* compiled from: NetworkUsageUploadInteractor.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public NetworkUsageUploadInteractor(DriverProvider driverProvider, DeviceSettings deviceSettings, AppPerformanceAnalytics networkUsageAnalytics, NetworkUsageManager networkUsageManager, TrueTimeProvider trueTimeProvider) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(deviceSettings, "deviceSettings");
        Intrinsics.f(networkUsageAnalytics, "networkUsageAnalytics");
        Intrinsics.f(networkUsageManager, "networkUsageManager");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        this.f26682a = driverProvider;
        this.f26683b = deviceSettings;
        this.f26684c = networkUsageAnalytics;
        this.f26685d = networkUsageManager;
        this.f26686e = trueTimeProvider;
    }

    private final NetworkUsageUpload a() {
        return new NetworkUsageUpload(this.f26686e.b(), this.f26685d.b());
    }

    private final void b(long j8, NetworkUsage networkUsage) {
        this.f26684c.t0(this.f26682a.f(), this.f26682a.c(), j8, this.f26686e.b(), networkUsage);
    }

    public final void c() {
        NetworkUsageUpload g8 = this.f26683b.g();
        if (g8 == null) {
            this.f26683b.r(a());
        } else if (this.f26686e.b() - g8.getLastUploadTimeInMs() >= 86400000) {
            NetworkUsage a8 = this.f26685d.a(g8.getNetworkUsage());
            if (a8.getReceivedBytes() > 0 && a8.getSentBytes() > 0) {
                b(g8.getLastUploadTimeInMs(), a8);
            }
            this.f26683b.r(a());
        }
    }
}
