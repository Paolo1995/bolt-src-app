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
public final class ul implements Factory<tl> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ip> f45388a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<xn> f45389b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<q8> f45390c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ye> f45391d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<yl> f45392e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<x1> f45393f;

    public ul(Provider<ip> provider, Provider<xn> provider2, Provider<q8> provider3, Provider<ye> provider4, Provider<yl> provider5, Provider<x1> provider6) {
        this.f45388a = provider;
        this.f45389b = provider2;
        this.f45390c = provider3;
        this.f45391d = provider4;
        this.f45392e = provider5;
        this.f45393f = provider6;
    }

    public static tl b(ip ipVar, xn xnVar, q8 q8Var, ye yeVar, yl ylVar, x1 x1Var) {
        return new tl(ipVar, xnVar, q8Var, yeVar, ylVar, x1Var);
    }

    public static ul c(Provider<ip> provider, Provider<xn> provider2, Provider<q8> provider3, Provider<ye> provider4, Provider<yl> provider5, Provider<x1> provider6) {
        return new ul(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public tl get() {
        return b(this.f45388a.get(), this.f45389b.get(), this.f45390c.get(), this.f45391d.get(), this.f45392e.get(), this.f45393f.get());
    }
}
