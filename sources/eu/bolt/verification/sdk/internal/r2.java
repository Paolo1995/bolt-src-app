package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.countrypicker.CountryPickerRibBuilder.CountryPickerRibScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class r2 implements Factory<q2> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<o2> f44713a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<t2> f44714b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<qe> f44715c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<bg> f44716d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<s2> f44717e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ib> f44718f;

    public r2(Provider<o2> provider, Provider<t2> provider2, Provider<qe> provider3, Provider<bg> provider4, Provider<s2> provider5, Provider<ib> provider6) {
        this.f44713a = provider;
        this.f44714b = provider2;
        this.f44715c = provider3;
        this.f44716d = provider4;
        this.f44717e = provider5;
        this.f44718f = provider6;
    }

    public static q2 b(o2 o2Var, t2 t2Var, qe qeVar, bg bgVar, s2 s2Var, ib ibVar) {
        return new q2(o2Var, t2Var, qeVar, bgVar, s2Var, ibVar);
    }

    public static r2 c(Provider<o2> provider, Provider<t2> provider2, Provider<qe> provider3, Provider<bg> provider4, Provider<s2> provider5, Provider<ib> provider6) {
        return new r2(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public q2 get() {
        return b(this.f44713a.get(), this.f44714b.get(), this.f44715c.get(), this.f44716d.get(), this.f44717e.get(), this.f44718f.get());
    }
}
