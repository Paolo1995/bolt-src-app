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
public final class vk implements Factory<uk> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<tc> f45456a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ip> f45457b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<xn> f45458c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<rq> f45459d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<x1> f45460e;

    public vk(Provider<tc> provider, Provider<ip> provider2, Provider<xn> provider3, Provider<rq> provider4, Provider<x1> provider5) {
        this.f45456a = provider;
        this.f45457b = provider2;
        this.f45458c = provider3;
        this.f45459d = provider4;
        this.f45460e = provider5;
    }

    public static uk b(tc tcVar, ip ipVar, xn xnVar, rq rqVar, x1 x1Var) {
        return new uk(tcVar, ipVar, xnVar, rqVar, x1Var);
    }

    public static vk c(Provider<tc> provider, Provider<ip> provider2, Provider<xn> provider3, Provider<rq> provider4, Provider<x1> provider5) {
        return new vk(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public uk get() {
        return b(this.f45456a.get(), this.f45457b.get(), this.f45458c.get(), this.f45459d.get(), this.f45460e.get());
    }
}
