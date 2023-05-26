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
public final class bm implements Factory<am> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<vb> f42374a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ke> f42375b;

    public bm(Provider<vb> provider, Provider<ke> provider2) {
        this.f42374a = provider;
        this.f42375b = provider2;
    }

    public static am b(vb vbVar, ke keVar) {
        return new am(vbVar, keVar);
    }

    public static bm c(Provider<vb> provider, Provider<ke> provider2) {
        return new bm(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public am get() {
        return b(this.f42374a.get(), this.f42375b.get());
    }
}
