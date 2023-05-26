package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class wn implements Factory<vn> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<wp> f45576a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<fo> f45577b;

    public wn(Provider<wp> provider, Provider<fo> provider2) {
        this.f45576a = provider;
        this.f45577b = provider2;
    }

    public static vn b(wp wpVar, fo foVar) {
        return new vn(wpVar, foVar);
    }

    public static wn c(Provider<wp> provider, Provider<fo> provider2) {
        return new wn(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public vn get() {
        return b(this.f45576a.get(), this.f45577b.get());
    }
}
