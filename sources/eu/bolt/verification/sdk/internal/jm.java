package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.VerificationSDKConfiguration;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class jm implements a0 {

    /* renamed from: a  reason: collision with root package name */
    private final VerificationSDKConfiguration f43759a;

    @Inject
    public jm(VerificationSDKConfiguration verificationSDKConfiguration) {
        Intrinsics.f(verificationSDKConfiguration, "verificationSDKConfiguration");
        this.f43759a = verificationSDKConfiguration;
    }

    @Override // eu.bolt.verification.sdk.internal.a0
    public String a() {
        return this.f43759a.l();
    }
}
