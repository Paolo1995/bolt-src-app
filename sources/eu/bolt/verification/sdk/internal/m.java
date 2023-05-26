package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.VerificationSDKActivity;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class m implements Factory<VerificationSDKActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final g f44110a;

    public m(g gVar) {
        this.f44110a = gVar;
    }

    public static m b(g gVar) {
        return new m(gVar);
    }

    public static VerificationSDKActivity c(g gVar) {
        return (VerificationSDKActivity) Preconditions.checkNotNullFromProvides(gVar.f());
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public VerificationSDKActivity get() {
        return c(this.f44110a);
    }
}
