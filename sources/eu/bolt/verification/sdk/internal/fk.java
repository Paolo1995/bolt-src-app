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
public final class fk implements Factory<ek> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ck> f43007a;

    public fk(Provider<ck> provider) {
        this.f43007a = provider;
    }

    public static ek b(ck ckVar) {
        return new ek(ckVar);
    }

    public static fk c(Provider<ck> provider) {
        return new fk(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ek get() {
        return b(this.f43007a.get());
    }
}
