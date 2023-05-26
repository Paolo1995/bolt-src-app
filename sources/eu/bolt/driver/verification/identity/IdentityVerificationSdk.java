package eu.bolt.driver.verification.identity;

import android.app.Application;
import eu.bolt.driver.verification.identity.config.DynamicVerificationConfigProvider;
import eu.bolt.driver.verification.identity.config.StaticVerificationConfig;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityVerificationSdk.kt */
/* loaded from: classes5.dex */
public final class IdentityVerificationSdk {

    /* renamed from: a  reason: collision with root package name */
    public static final IdentityVerificationSdk f41584a = new IdentityVerificationSdk();

    /* renamed from: b  reason: collision with root package name */
    private static IdentityVerificationManager f41585b;

    private IdentityVerificationSdk() {
    }

    public final IdentityVerificationManager a() {
        return f41585b;
    }

    public final void b(Application application, StaticVerificationConfig staticConfig, DynamicVerificationConfigProvider dynamicConfigProvider, VerificationAnalytics verificationAnalytics) {
        Intrinsics.f(application, "application");
        Intrinsics.f(staticConfig, "staticConfig");
        Intrinsics.f(dynamicConfigProvider, "dynamicConfigProvider");
        Intrinsics.f(verificationAnalytics, "verificationAnalytics");
        IdentityVerificationManager identityVerificationManager = f41585b;
        if (identityVerificationManager != null) {
            identityVerificationManager.a(staticConfig, dynamicConfigProvider);
        }
        if (f41585b == null) {
            f41585b = new IdentityVerificationManager(application, staticConfig, dynamicConfigProvider, verificationAnalytics);
        }
    }
}
