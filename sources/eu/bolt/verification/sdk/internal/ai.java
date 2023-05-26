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
public final class ai implements Factory<zh> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<hi> f42085a;

    public ai(Provider<hi> provider) {
        this.f42085a = provider;
    }

    public static ai a(Provider<hi> provider) {
        return new ai(provider);
    }

    public static zh c(hi hiVar) {
        return new zh(hiVar);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public zh get() {
        return c(this.f42085a.get());
    }
}
