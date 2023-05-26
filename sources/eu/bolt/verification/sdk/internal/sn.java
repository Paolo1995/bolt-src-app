package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.rn;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.core.rib.VerificationFlowBuilder.VerificationFlowScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class sn implements Factory<xn> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<xg> f45053a;

    public sn(Provider<xg> provider) {
        this.f45053a = provider;
    }

    public static sn a(Provider<xg> provider) {
        return new sn(provider);
    }

    public static xn c(xg xgVar) {
        return (xn) Preconditions.checkNotNullFromProvides(rn.c.b(xgVar));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public xn get() {
        return c(this.f45053a.get());
    }
}
