package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.VerificationSDKActivity;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class vo implements Factory<uo> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VerificationSDKActivity> f45464a;

    public vo(Provider<VerificationSDKActivity> provider) {
        this.f45464a = provider;
    }

    public static uo b(VerificationSDKActivity verificationSDKActivity) {
        return new uo(verificationSDKActivity);
    }

    public static vo c(Provider<VerificationSDKActivity> provider) {
        return new vo(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public uo get() {
        return b(this.f45464a.get());
    }
}
