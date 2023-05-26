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
public final class pq implements Factory<oq> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<wp> f44566a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<fo> f44567b;

    public pq(Provider<wp> provider, Provider<fo> provider2) {
        this.f44566a = provider;
        this.f44567b = provider2;
    }

    public static oq b(wp wpVar, fo foVar) {
        return new oq(wpVar, foVar);
    }

    public static pq c(Provider<wp> provider, Provider<fo> provider2) {
        return new pq(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public oq get() {
        return b(this.f44566a.get(), this.f44567b.get());
    }
}
