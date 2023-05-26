package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.yq;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.android.webview.WebPageRibBuilder.WebViewScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class zq implements Factory<gr> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<hr> f45877a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ar> f45878b;

    public zq(Provider<hr> provider, Provider<ar> provider2) {
        this.f45877a = provider;
        this.f45878b = provider2;
    }

    public static gr b(hr hrVar, ar arVar) {
        return (gr) Preconditions.checkNotNullFromProvides(yq.c.a(hrVar, arVar));
    }

    public static zq c(Provider<hr> provider, Provider<ar> provider2) {
        return new zq(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public gr get() {
        return b(this.f45877a.get(), this.f45878b.get());
    }
}
