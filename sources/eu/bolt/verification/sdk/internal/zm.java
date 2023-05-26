package eu.bolt.verification.sdk.internal;

import android.view.ViewGroup;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.wm;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.core.rib.camera.VerificationCameraBuilder.VerificationCameraScope")
@DaggerGenerated
@QualifierMetadata({"eu.bolt.client.commondeps.ui.FullScreenContainer"})
/* loaded from: classes5.dex */
public final class zm implements Factory<in> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<jn> f45872a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<wm.b> f45873b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<fn> f45874c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ViewGroup> f45875d;

    public zm(Provider<jn> provider, Provider<wm.b> provider2, Provider<fn> provider3, Provider<ViewGroup> provider4) {
        this.f45872a = provider;
        this.f45873b = provider2;
        this.f45874c = provider3;
        this.f45875d = provider4;
    }

    public static in b(jn jnVar, wm.b bVar, fn fnVar, ViewGroup viewGroup) {
        return (in) Preconditions.checkNotNullFromProvides(wm.c.c(jnVar, bVar, fnVar, viewGroup));
    }

    public static zm c(Provider<jn> provider, Provider<wm.b> provider2, Provider<fn> provider3, Provider<ViewGroup> provider4) {
        return new zm(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public in get() {
        return b(this.f45872a.get(), this.f45873b.get(), this.f45874c.get(), this.f45875d.get());
    }
}
