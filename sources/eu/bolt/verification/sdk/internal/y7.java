package eu.bolt.verification.sdk.internal;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class y7 implements Factory<x7> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<mn> f45736a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<d1> f45737b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Context> f45738c;

    public y7(Provider<mn> provider, Provider<d1> provider2, Provider<Context> provider3) {
        this.f45736a = provider;
        this.f45737b = provider2;
        this.f45738c = provider3;
    }

    public static x7 b(mn mnVar, d1 d1Var, Context context) {
        return new x7(mnVar, d1Var, context);
    }

    public static y7 c(Provider<mn> provider, Provider<d1> provider2, Provider<Context> provider3) {
        return new y7(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public x7 get() {
        return b(this.f45736a.get(), this.f45737b.get(), this.f45738c.get());
    }
}
