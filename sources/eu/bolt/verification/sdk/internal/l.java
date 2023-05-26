package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.rib.RibActivity;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class l implements Factory<RibActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final g f43928a;

    public l(g gVar) {
        this.f43928a = gVar;
    }

    public static l b(g gVar) {
        return new l(gVar);
    }

    public static RibActivity c(g gVar) {
        return (RibActivity) Preconditions.checkNotNullFromProvides(gVar.e());
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public RibActivity get() {
        return c(this.f43928a);
    }
}
