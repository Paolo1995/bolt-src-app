package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.stories.rib.flow.StoryFlowBuilder.StoryFlowScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class zi implements Factory<yi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xi> f45868a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<aj> f45869b;

    public zi(Provider<xi> provider, Provider<aj> provider2) {
        this.f45868a = provider;
        this.f45869b = provider2;
    }

    public static yi b(xi xiVar, aj ajVar) {
        return new yi(xiVar, ajVar);
    }

    public static zi c(Provider<xi> provider, Provider<aj> provider2) {
        return new zi(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public yi get() {
        return b(this.f45868a.get(), this.f45869b.get());
    }
}
