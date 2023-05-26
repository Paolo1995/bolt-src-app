package eu.bolt.verification.sdk;

import android.app.Application;
import eu.bolt.verification.sdk.VerificationSDKConfiguration;
import eu.bolt.verification.sdk.internal.y4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class VerificationSDK<T extends VerificationSDKConfiguration> {

    /* renamed from: a  reason: collision with root package name */
    private final Application f41926a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<T> f41927b;

    public VerificationSDK(Application application, Class<T> configurationClass) {
        Intrinsics.f(application, "application");
        Intrinsics.f(configurationClass, "configurationClass");
        this.f41926a = application;
        this.f41927b = configurationClass;
    }

    public final void a(String flowId) {
        Intrinsics.f(flowId, "flowId");
        y4.f45720a.b(this.f41926a);
        VerificationSDKActivity.f41928o.a(this.f41926a, flowId, this.f41927b);
    }
}
