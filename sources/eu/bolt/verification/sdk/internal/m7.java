package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.l7;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.core.rib.formbuilder.FormBuilderBuilder.FormBuilderScope")
@DaggerGenerated
@QualifierMetadata({"eu.bolt.client.commondeps.ui.FullScreenContainer"})
/* loaded from: classes5.dex */
public final class m7 implements Factory<u7> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<v7> f44158a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<l7.b> f44159b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<r7> f44160c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ViewGroup> f44161d;

    public m7(Provider<v7> provider, Provider<l7.b> provider2, Provider<r7> provider3, Provider<ViewGroup> provider4) {
        this.f44158a = provider;
        this.f44159b = provider2;
        this.f44160c = provider3;
        this.f44161d = provider4;
    }

    public static m7 a(Provider<v7> provider, Provider<l7.b> provider2, Provider<r7> provider3, Provider<ViewGroup> provider4) {
        return new m7(provider, provider2, provider3, provider4);
    }

    public static u7 c(v7 v7Var, l7.b bVar, r7 r7Var, ViewGroup viewGroup) {
        return (u7) Preconditions.checkNotNullFromProvides(l7.c.a(v7Var, bVar, r7Var, viewGroup));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public u7 get() {
        return c(this.f44158a.get(), this.f44159b.get(), this.f44160c.get(), this.f44161d.get());
    }
}
