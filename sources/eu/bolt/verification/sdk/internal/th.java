package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.sh;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.stories.rib.storyset.StoriesBuilder.StoriesScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class th implements Factory<ii> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<hi> f45201a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ei> f45202b;

    public th(Provider<hi> provider, Provider<ei> provider2) {
        this.f45201a = provider;
        this.f45202b = provider2;
    }

    public static ii b(hi hiVar, ei eiVar) {
        return (ii) Preconditions.checkNotNullFromProvides(sh.c.a(hiVar, eiVar));
    }

    public static th c(Provider<hi> provider, Provider<ei> provider2) {
        return new th(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ii get() {
        return b(this.f45201a.get(), this.f45202b.get());
    }
}
