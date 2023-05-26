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
public final class xk implements Factory<wk> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<tc> f45666a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<xn> f45667b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<eh> f45668c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<bd> f45669d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<q8> f45670e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<x1> f45671f;

    public xk(Provider<tc> provider, Provider<xn> provider2, Provider<eh> provider3, Provider<bd> provider4, Provider<q8> provider5, Provider<x1> provider6) {
        this.f45666a = provider;
        this.f45667b = provider2;
        this.f45668c = provider3;
        this.f45669d = provider4;
        this.f45670e = provider5;
        this.f45671f = provider6;
    }

    public static wk b(tc tcVar, xn xnVar, eh ehVar, bd bdVar, q8 q8Var, x1 x1Var) {
        return new wk(tcVar, xnVar, ehVar, bdVar, q8Var, x1Var);
    }

    public static xk c(Provider<tc> provider, Provider<xn> provider2, Provider<eh> provider3, Provider<bd> provider4, Provider<q8> provider5, Provider<x1> provider6) {
        return new xk(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public wk get() {
        return b(this.f45666a.get(), this.f45667b.get(), this.f45668c.get(), this.f45669d.get(), this.f45670e.get(), this.f45671f.get());
    }
}
