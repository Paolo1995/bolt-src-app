package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.vi;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.stories.rib.flow.StoryFlowBuilder.StoryFlowScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class wi implements Factory<bj> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ViewGroup> f45554a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<vi.b> f45555b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<yi> f45556c;

    public wi(Provider<ViewGroup> provider, Provider<vi.b> provider2, Provider<yi> provider3) {
        this.f45554a = provider;
        this.f45555b = provider2;
        this.f45556c = provider3;
    }

    public static bj b(ViewGroup viewGroup, vi.b bVar, yi yiVar) {
        return (bj) Preconditions.checkNotNullFromProvides(vi.c.a(viewGroup, bVar, yiVar));
    }

    public static wi c(Provider<ViewGroup> provider, Provider<vi.b> provider2, Provider<yi> provider3) {
        return new wi(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public bj get() {
        return b(this.f45554a.get(), this.f45555b.get(), this.f45556c.get());
    }
}
