package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class h implements Factory<v4> {

    /* renamed from: a  reason: collision with root package name */
    private final g f43186a;

    public h(g gVar) {
        this.f43186a = gVar;
    }

    public static h a(g gVar) {
        return new h(gVar);
    }

    public static v4 c(g gVar) {
        return (v4) Preconditions.checkNotNullFromProvides(gVar.a());
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public v4 get() {
        return c(this.f43186a);
    }
}
