package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.rn;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.core.rib.VerificationFlowBuilder.VerificationFlowScope")
@DaggerGenerated
@QualifierMetadata({"eu.bolt.client.commondeps.ui.FullScreenContainer"})
/* loaded from: classes5.dex */
public final class un implements Factory<Cdo> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ViewGroup> f45396a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<rn.b> f45397b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<zn<Cdo>> f45398c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ViewGroup> f45399d;

    public un(Provider<ViewGroup> provider, Provider<rn.b> provider2, Provider<zn<Cdo>> provider3, Provider<ViewGroup> provider4) {
        this.f45396a = provider;
        this.f45397b = provider2;
        this.f45398c = provider3;
        this.f45399d = provider4;
    }

    public static Cdo b(ViewGroup viewGroup, rn.b bVar, zn<Cdo> znVar, ViewGroup viewGroup2) {
        return (Cdo) Preconditions.checkNotNullFromProvides(rn.c.a(viewGroup, bVar, znVar, viewGroup2));
    }

    public static un c(Provider<ViewGroup> provider, Provider<rn.b> provider2, Provider<zn<Cdo>> provider3, Provider<ViewGroup> provider4) {
        return new un(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public Cdo get() {
        return b(this.f45396a.get(), this.f45397b.get(), this.f45398c.get(), this.f45399d.get());
    }
}
