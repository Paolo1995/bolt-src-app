package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.android.webview.WebPageRibBuilder.WebViewScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class fr implements Factory<er> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<hr> f43058a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<lr> f43059b;

    public fr(Provider<hr> provider, Provider<lr> provider2) {
        this.f43058a = provider;
        this.f43059b = provider2;
    }

    public static er b(hr hrVar, lr lrVar) {
        return new er(hrVar, lrVar);
    }

    public static fr c(Provider<hr> provider, Provider<lr> provider2) {
        return new fr(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public er get() {
        return b(this.f43058a.get(), this.f43059b.get());
    }
}
