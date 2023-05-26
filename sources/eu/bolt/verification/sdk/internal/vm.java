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
public final class vm implements Factory<um> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<qm> f45461a;

    public vm(Provider<qm> provider) {
        this.f45461a = provider;
    }

    public static um b(qm qmVar) {
        return new um(qmVar);
    }

    public static vm c(Provider<qm> provider) {
        return new vm(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public um get() {
        return b(this.f45461a.get());
    }
}
