package eu.bolt.driver.verification.identity;

import android.app.Application;
import eu.bolt.driver.verification.identity.SingletonConfigImpl;
import eu.bolt.driver.verification.identity.config.DynamicVerificationConfigProvider;
import eu.bolt.driver.verification.identity.config.StaticVerificationConfig;
import eu.bolt.verification.sdk.VerificationSDK;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityVerificationManager.kt */
/* loaded from: classes5.dex */
public final class IdentityVerificationManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f41582a = new Companion(null);

    /* renamed from: b  reason: collision with root package name */
    private static VerificationSDK<SingletonConfigImpl> f41583b;

    /* compiled from: IdentityVerificationManager.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IdentityVerificationManager(Application application, StaticVerificationConfig staticVerificationConfig, DynamicVerificationConfigProvider dynamicVerificationConfigProvider, VerificationAnalytics verificationAnalytics) {
        Intrinsics.f(application, "application");
        Intrinsics.f(staticVerificationConfig, "staticVerificationConfig");
        Intrinsics.f(dynamicVerificationConfigProvider, "dynamicVerificationConfigProvider");
        Intrinsics.f(verificationAnalytics, "verificationAnalytics");
        SingletonConfigImpl.Companion companion = SingletonConfigImpl.f41586a;
        companion.f(verificationAnalytics);
        companion.e(staticVerificationConfig);
        companion.d(dynamicVerificationConfigProvider);
        if (f41583b == null) {
            f41583b = new VerificationSDK<>(application, SingletonConfigImpl.class);
        }
    }

    public final void a(StaticVerificationConfig staticVerificationConfig, DynamicVerificationConfigProvider dynamicVerificationConfigProvider) {
        Intrinsics.f(staticVerificationConfig, "staticVerificationConfig");
        Intrinsics.f(dynamicVerificationConfigProvider, "dynamicVerificationConfigProvider");
        SingletonConfigImpl.Companion companion = SingletonConfigImpl.f41586a;
        companion.e(staticVerificationConfig);
        companion.d(dynamicVerificationConfigProvider);
    }

    public final void b(String flowId) {
        Unit unit;
        Intrinsics.f(flowId, "flowId");
        VerificationSDK<SingletonConfigImpl> verificationSDK = f41583b;
        if (verificationSDK != null) {
            verificationSDK.a(flowId);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit != null) {
            return;
        }
        throw new IllegalStateException("Verification SDK is not initialized");
    }
}
