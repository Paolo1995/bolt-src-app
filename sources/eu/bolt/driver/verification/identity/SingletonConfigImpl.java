package eu.bolt.driver.verification.identity;

import eu.bolt.driver.verification.identity.config.DynamicVerificationConfigProvider;
import eu.bolt.driver.verification.identity.config.StaticVerificationConfig;
import eu.bolt.verification.sdk.ClientType;
import eu.bolt.verification.sdk.VerificationSDKConfiguration;
import eu.bolt.verification.sdk.VerificationStatusCallback;
import eu.bolt.verification.sdk.analytics.VerificationAnalyticsManager;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

/* compiled from: SingletonConfigImpl.kt */
/* loaded from: classes5.dex */
public final class SingletonConfigImpl implements VerificationSDKConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f41586a = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    public static StaticVerificationConfig f41587b;

    /* renamed from: c  reason: collision with root package name */
    public static DynamicVerificationConfigProvider f41588c;

    /* renamed from: d  reason: collision with root package name */
    public static VerificationAnalytics f41589d;

    /* compiled from: SingletonConfigImpl.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DynamicVerificationConfigProvider a() {
            DynamicVerificationConfigProvider dynamicVerificationConfigProvider = SingletonConfigImpl.f41588c;
            if (dynamicVerificationConfigProvider != null) {
                return dynamicVerificationConfigProvider;
            }
            Intrinsics.w("dynamicVerificationConfigProvider");
            return null;
        }

        public final StaticVerificationConfig b() {
            StaticVerificationConfig staticVerificationConfig = SingletonConfigImpl.f41587b;
            if (staticVerificationConfig != null) {
                return staticVerificationConfig;
            }
            Intrinsics.w("staticVerificationConfig");
            return null;
        }

        public final VerificationAnalytics c() {
            VerificationAnalytics verificationAnalytics = SingletonConfigImpl.f41589d;
            if (verificationAnalytics != null) {
                return verificationAnalytics;
            }
            Intrinsics.w("verificationAnalytics");
            return null;
        }

        public final void d(DynamicVerificationConfigProvider dynamicVerificationConfigProvider) {
            Intrinsics.f(dynamicVerificationConfigProvider, "<set-?>");
            SingletonConfigImpl.f41588c = dynamicVerificationConfigProvider;
        }

        public final void e(StaticVerificationConfig staticVerificationConfig) {
            Intrinsics.f(staticVerificationConfig, "<set-?>");
            SingletonConfigImpl.f41587b = staticVerificationConfig;
        }

        public final void f(VerificationAnalytics verificationAnalytics) {
            Intrinsics.f(verificationAnalytics, "<set-?>");
            SingletonConfigImpl.f41589d = verificationAnalytics;
        }
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public boolean a() {
        return true;
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public VerificationStatusCallback b() {
        return VerificationSDKConfiguration.DefaultImpls.b(this);
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public String c() {
        return VerificationSDKConfiguration.DefaultImpls.a(this);
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public ClientType d() {
        return ClientType.DRIVER;
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public String e() {
        return f41586a.b().b();
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public String f() {
        return f41586a.b().c();
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public Retrofit.Builder g() {
        return f41586a.b().e();
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public String h() {
        return f41586a.a().a().c();
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public String i() {
        return f41586a.b().d();
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public String j() {
        return f41586a.b().a();
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public String k() {
        return f41586a.a().a().b();
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public String l() {
        String a8 = f41586a.a().a().a();
        return "Bearer " + a8;
    }

    @Override // eu.bolt.verification.sdk.VerificationSDKConfiguration
    public VerificationAnalyticsManager m() {
        return new VerificationAnalyticsManager() { // from class: eu.bolt.driver.verification.identity.SingletonConfigImpl$provideAnalyticsManager$1
            @Override // eu.bolt.verification.sdk.analytics.VerificationAnalyticsManager
            public void a(eu.bolt.verification.sdk.analytics.events.VerificationEvent analyticsEvent) {
                Map q8;
                Intrinsics.f(analyticsEvent, "analyticsEvent");
                VerificationAnalytics c8 = SingletonConfigImpl.f41586a.c();
                String a8 = analyticsEvent.a();
                q8 = MapsKt__MapsKt.q(analyticsEvent.b());
                c8.h2(new VerificationEvent(a8, q8));
            }

            @Override // eu.bolt.verification.sdk.analytics.VerificationAnalyticsManager
            public void b(eu.bolt.verification.sdk.analytics.events.VerificationScreen analyticsScreen) {
                Map q8;
                Intrinsics.f(analyticsScreen, "analyticsScreen");
                VerificationAnalytics c8 = SingletonConfigImpl.f41586a.c();
                String a8 = analyticsScreen.a();
                q8 = MapsKt__MapsKt.q(analyticsScreen.b());
                c8.F3(new VerificationScreen(a8, q8));
            }
        };
    }
}
