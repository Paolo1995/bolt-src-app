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
public final class nr implements Factory<mr> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<jc> f44360a;

    public nr(Provider<jc> provider) {
        this.f44360a = provider;
    }

    public static mr b(jc jcVar) {
        return new mr(jcVar);
    }

    public static nr c(Provider<jc> provider) {
        return new nr(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public mr get() {
        return b(this.f44360a.get());
    }
}
