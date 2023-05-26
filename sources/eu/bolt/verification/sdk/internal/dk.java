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
public final class dk implements Factory<ck> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<vj> f42654a;

    public dk(Provider<vj> provider) {
        this.f42654a = provider;
    }

    public static ck b(vj vjVar) {
        return new ck(vjVar);
    }

    public static dk c(Provider<vj> provider) {
        return new dk(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ck get() {
        return b(this.f42654a.get());
    }
}
