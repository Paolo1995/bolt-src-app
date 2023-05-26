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
public final class kd implements Factory<jd> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<rc> f43859a;

    public kd(Provider<rc> provider) {
        this.f43859a = provider;
    }

    public static jd b(rc rcVar) {
        return new jd(rcVar);
    }

    public static kd c(Provider<rc> provider) {
        return new kd(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public jd get() {
        return b(this.f43859a.get());
    }
}
