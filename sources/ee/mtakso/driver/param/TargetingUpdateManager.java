package ee.mtakso.driver.param;

import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.driver.DriverConfigurationClient;
import ee.mtakso.driver.network.client.targeting.TargetingParameters;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import eu.bolt.driver.core.field.io.LongReadWrite;
import eu.bolt.driver.core.network.client.driver.DriverConfiguration;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TargetingUpdateManager.kt */
/* loaded from: classes3.dex */
public final class TargetingUpdateManager {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f23235g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DriverConfigurationClient f23236a;

    /* renamed from: b  reason: collision with root package name */
    private final Features f23237b;

    /* renamed from: c  reason: collision with root package name */
    private final DriverProvider f23238c;

    /* renamed from: d  reason: collision with root package name */
    private final LoginAnalytics f23239d;

    /* renamed from: e  reason: collision with root package name */
    private final TrueTimeProvider f23240e;

    /* renamed from: f  reason: collision with root package name */
    private final Lazy f23241f;

    /* compiled from: TargetingUpdateManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TargetingUpdateManager(DriverConfigurationClient driverConfigClient, Features features, DriverProvider driverProvider, LoginAnalytics loginAnalytics, TrueTimeProvider trueTimeProvider) {
        Lazy b8;
        Intrinsics.f(driverConfigClient, "driverConfigClient");
        Intrinsics.f(features, "features");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        this.f23236a = driverConfigClient;
        this.f23237b = features;
        this.f23238c = driverProvider;
        this.f23239d = loginAnalytics;
        this.f23240e = trueTimeProvider;
        b8 = LazyKt__LazyJVMKt.b(new Function0<LongReadWrite>() { // from class: ee.mtakso.driver.param.TargetingUpdateManager$longRW$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final LongReadWrite invoke() {
                DriverProvider driverProvider2;
                driverProvider2 = TargetingUpdateManager.this.f23238c;
                return new LongReadWrite(driverProvider2.s());
            }
        });
        this.f23241f = b8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(TargetingParameters targetingParameters) {
        this.f23237b.d(targetingParameters);
        this.f23238c.l(targetingParameters);
        Features features = this.f23237b;
        Feature.Type type = Feature.Type.BETA_USER;
        if (!features.c(type)) {
            this.f23239d.m2(Boolean.valueOf(this.f23237b.b(type)));
        }
    }

    private final Completable j() {
        Single<DriverConfiguration> b8 = this.f23236a.b();
        final Function1<DriverConfiguration, Unit> function1 = new Function1<DriverConfiguration, Unit>() { // from class: ee.mtakso.driver.param.TargetingUpdateManager$updateTargeting$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(DriverConfiguration driverConfiguration) {
                TargetingUpdateManager.this.h(new TargetingParameters(driverConfiguration.c().j()));
                TargetingUpdateManager.this.g();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DriverConfiguration driverConfiguration) {
                b(driverConfiguration);
                return Unit.f50853a;
            }
        };
        Completable A = b8.o(new Consumer() { // from class: ee.mtakso.driver.param.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TargetingUpdateManager.k(Function1.this, obj);
            }
        }).v().A();
        Intrinsics.e(A, "private fun updateTarget… .onErrorComplete()\n    }");
        return A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Completable d() {
        if (!this.f23237b.b(Feature.Type.LIVE_UPDATE_TARGETING)) {
            Completable g8 = Completable.g();
            Intrinsics.e(g8, "complete()");
            return g8;
        } else if (!l()) {
            return j();
        } else {
            Completable g9 = Completable.g();
            Intrinsics.e(g9, "complete()");
            return g9;
        }
    }

    public final LongReadWrite e() {
        return (LongReadWrite) this.f23241f.getValue();
    }

    public final long f() {
        return e().d("TARGETING_LAST_UPDATE_TIME", 0L).longValue();
    }

    public final void g() {
        i(this.f23240e.b());
    }

    public final void i(long j8) {
        e().e("TARGETING_LAST_UPDATE_TIME", j8);
    }

    public final boolean l() {
        if (Math.abs(this.f23240e.b() - f()) < TimeUnit.DAYS.toMillis(1L)) {
            return true;
        }
        return false;
    }
}
