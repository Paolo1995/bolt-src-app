package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.VerificationSDKActivity;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class uo implements qj {

    /* renamed from: a  reason: collision with root package name */
    private final VerificationSDKActivity f45400a;

    @Inject
    public uo(VerificationSDKActivity verificationSDKActivity) {
        Intrinsics.f(verificationSDKActivity, "verificationSDKActivity");
        this.f45400a = verificationSDKActivity;
    }

    @Override // eu.bolt.verification.sdk.internal.qj
    public void c(String storyId) {
        Intrinsics.f(storyId, "storyId");
        this.f45400a.j0(storyId);
    }
}
