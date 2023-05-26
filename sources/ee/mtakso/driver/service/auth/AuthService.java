package ee.mtakso.driver.service.auth;

import android.annotation.SuppressLint;
import dagger.Lazy;
import ee.mtakso.driver.features.Feature;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.param.DriverConfig;
import ee.mtakso.driver.param.DriverFeatures;
import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.service.analytics.event.facade.DriverAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.LoginAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.SettingsAnalytics;
import ee.mtakso.driver.service.chat.ChatService;
import ee.mtakso.driver.service.driver.DriverManager;
import ee.mtakso.driver.service.google.FirebaseRemoteConfigManager;
import ee.mtakso.driver.service.modules.polling.Poller;
import ee.mtakso.driver.service.order.details.OrdersCache;
import ee.mtakso.driver.service.pollerv2.PollerService;
import ee.mtakso.driver.service.restriction.DriverRestrictionManager;
import ee.mtakso.driver.service.token.TokenManager;
import eu.bolt.driver.core.theme.AppThemeManager;
import eu.bolt.kalev.Kalev;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthService.kt */
/* loaded from: classes3.dex */
public final class AuthService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final DriverConfig f23595a;

    /* renamed from: b  reason: collision with root package name */
    private final DriverFeatures f23596b;

    /* renamed from: c  reason: collision with root package name */
    private final Features f23597c;

    /* renamed from: d  reason: collision with root package name */
    private final LoginAnalytics f23598d;

    /* renamed from: e  reason: collision with root package name */
    private final DriverRestrictionManager f23599e;

    /* renamed from: f  reason: collision with root package name */
    private final Poller f23600f;

    /* renamed from: g  reason: collision with root package name */
    private final Lazy<ChatService> f23601g;

    /* renamed from: h  reason: collision with root package name */
    private final DriverAnalytics f23602h;

    /* renamed from: i  reason: collision with root package name */
    private final SettingsAnalytics f23603i;

    /* renamed from: j  reason: collision with root package name */
    private final FirebaseRemoteConfigManager f23604j;

    /* renamed from: k  reason: collision with root package name */
    private final DriverManager f23605k;

    /* renamed from: l  reason: collision with root package name */
    private final TokenManager f23606l;

    /* renamed from: m  reason: collision with root package name */
    private final AppThemeManager f23607m;

    /* renamed from: n  reason: collision with root package name */
    private final OrdersCache f23608n;

    /* renamed from: o  reason: collision with root package name */
    private final PollerService f23609o;

    @Inject
    public AuthService(DriverConfig driver, DriverFeatures driverFeatures, Features features, LoginAnalytics loginAnalytics, DriverRestrictionManager driverRestrictionManager, Poller poller, Lazy<ChatService> chatService, DriverAnalytics driverAnalytics, SettingsAnalytics settingsAnalytics, FirebaseRemoteConfigManager firebaseRemoteConfigManager, DriverManager driverManager, TokenManager tokenManager, AppThemeManager appThemeManager, OrdersCache ordersCache, PollerService pollerService) {
        Intrinsics.f(driver, "driver");
        Intrinsics.f(driverFeatures, "driverFeatures");
        Intrinsics.f(features, "features");
        Intrinsics.f(loginAnalytics, "loginAnalytics");
        Intrinsics.f(driverRestrictionManager, "driverRestrictionManager");
        Intrinsics.f(poller, "poller");
        Intrinsics.f(chatService, "chatService");
        Intrinsics.f(driverAnalytics, "driverAnalytics");
        Intrinsics.f(settingsAnalytics, "settingsAnalytics");
        Intrinsics.f(firebaseRemoteConfigManager, "firebaseRemoteConfigManager");
        Intrinsics.f(driverManager, "driverManager");
        Intrinsics.f(tokenManager, "tokenManager");
        Intrinsics.f(appThemeManager, "appThemeManager");
        Intrinsics.f(ordersCache, "ordersCache");
        Intrinsics.f(pollerService, "pollerService");
        this.f23595a = driver;
        this.f23596b = driverFeatures;
        this.f23597c = features;
        this.f23598d = loginAnalytics;
        this.f23599e = driverRestrictionManager;
        this.f23600f = poller;
        this.f23601g = chatService;
        this.f23602h = driverAnalytics;
        this.f23603i = settingsAnalytics;
        this.f23604j = firebaseRemoteConfigManager;
        this.f23605k = driverManager;
        this.f23606l = tokenManager;
        this.f23607m = appThemeManager;
        this.f23608n = ordersCache;
        this.f23609o = pollerService;
    }

    private final void a() {
        b();
        if (this.f23596b.I()) {
            this.f23609o.start();
        } else {
            this.f23600f.a();
        }
    }

    private final void b() {
        this.f23609o.stop();
        this.f23600f.b();
    }

    @SuppressLint({"CheckResult"})
    private final void g() {
        if (!this.f23599e.i()) {
            return;
        }
        a();
        this.f23601g.get().F();
    }

    private final void h() {
        m(this.f23595a);
        j();
        g();
    }

    private final void i() {
        this.f23606l.p();
        this.f23605k.g();
        this.f23608n.c();
        b();
    }

    private final void j() {
        Features features = this.f23597c;
        Feature.Type type = Feature.Type.BETA_USER;
        if (!features.c(type)) {
            this.f23598d.m2(Boolean.valueOf(this.f23597c.b(type)));
        }
        Completable c8 = this.f23604j.c();
        Action action = new Action() { // from class: ee.mtakso.driver.service.auth.g
            @Override // io.reactivex.functions.Action
            public final void run() {
                AuthService.k();
            }
        };
        final AuthService$processTargeting$2 authService$processTargeting$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.auth.AuthService$processTargeting$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Failed to sync remote config");
            }
        };
        c8.G(action, new Consumer() { // from class: ee.mtakso.driver.service.auth.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AuthService.l(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k() {
        Kalev.d("Remote config synced");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void m(DriverConfig driverConfig) {
        this.f23598d.o1(driverConfig.t(), driverConfig.g());
        this.f23602h.x1(driverConfig.t(), driverConfig.j());
        this.f23603i.n1(this.f23607m.c());
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        h();
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        i();
    }
}
