package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.pi;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.stories.rib.singlestory.StoryBuilder.StoryScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class qi implements Factory<pj> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<oj> f44667a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<lj> f44668b;

    public qi(Provider<oj> provider, Provider<lj> provider2) {
        this.f44667a = provider;
        this.f44668b = provider2;
    }

    public static pj b(oj ojVar, lj ljVar) {
        return (pj) Preconditions.checkNotNullFromProvides(pi.c.a(ojVar, ljVar));
    }

    public static qi c(Provider<oj> provider, Provider<lj> provider2) {
        return new qi(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public pj get() {
        return b(this.f44667a.get(), this.f44668b.get());
    }
}
