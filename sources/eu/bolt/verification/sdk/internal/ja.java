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
public final class ja implements Factory<ia> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<eh> f43676a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<bd> f43677b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<q8> f43678c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<x1> f43679d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<xn> f43680e;

    public ja(Provider<eh> provider, Provider<bd> provider2, Provider<q8> provider3, Provider<x1> provider4, Provider<xn> provider5) {
        this.f43676a = provider;
        this.f43677b = provider2;
        this.f43678c = provider3;
        this.f43679d = provider4;
        this.f43680e = provider5;
    }

    public static ia b(eh ehVar, bd bdVar, q8 q8Var, x1 x1Var, xn xnVar) {
        return new ia(ehVar, bdVar, q8Var, x1Var, xnVar);
    }

    public static ja c(Provider<eh> provider, Provider<bd> provider2, Provider<q8> provider3, Provider<x1> provider4, Provider<xn> provider5) {
        return new ja(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ia get() {
        return b(this.f43676a.get(), this.f43677b.get(), this.f43678c.get(), this.f43679d.get(), this.f43680e.get());
    }
}
