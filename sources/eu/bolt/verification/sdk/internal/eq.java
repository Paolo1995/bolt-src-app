package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.VerificationSDKConfiguration;
import eu.bolt.verification.sdk.internal.b7;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class eq implements dl {

    /* renamed from: a  reason: collision with root package name */
    private final VerificationSDKConfiguration f42854a;

    @Inject
    public eq(VerificationSDKConfiguration verificationSDKConfiguration) {
        Intrinsics.f(verificationSDKConfiguration, "verificationSDKConfiguration");
        this.f42854a = verificationSDKConfiguration;
    }

    @Override // eu.bolt.verification.sdk.internal.dl
    public <T> T a(b7<T> experiment) {
        Intrinsics.f(experiment, "experiment");
        return experiment instanceof b7.a.b ? (T) Boolean.valueOf(this.f42854a.a()) : (T) Boolean.FALSE;
    }
}
