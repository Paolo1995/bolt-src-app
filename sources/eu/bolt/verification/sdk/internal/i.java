package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.coroutines.dispatchers.DispatchersBundle;

@ScopeMetadata("eu.bolt.verification.sdk.di.VerificationSDKScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class i implements Factory<DispatchersBundle> {

    /* renamed from: a  reason: collision with root package name */
    private final g f43431a;

    public i(g gVar) {
        this.f43431a = gVar;
    }

    public static i b(g gVar) {
        return new i(gVar);
    }

    public static DispatchersBundle c(g gVar) {
        return (DispatchersBundle) Preconditions.checkNotNullFromProvides(gVar.b());
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public DispatchersBundle get() {
        return c(this.f43431a);
    }
}
