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
public final class md implements Factory<ld> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<rc> f44174a;

    public md(Provider<rc> provider) {
        this.f44174a = provider;
    }

    public static ld b(rc rcVar) {
        return new ld(rcVar);
    }

    public static md c(Provider<rc> provider) {
        return new md(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ld get() {
        return b(this.f44174a.get());
    }
}
