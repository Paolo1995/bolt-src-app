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
public final class rm implements Factory<qm> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<jr> f44864a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<nm> f44865b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<lm> f44866c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<cq> f44867d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<fm> f44868e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<rq> f44869f;

    public rm(Provider<jr> provider, Provider<nm> provider2, Provider<lm> provider3, Provider<cq> provider4, Provider<fm> provider5, Provider<rq> provider6) {
        this.f44864a = provider;
        this.f44865b = provider2;
        this.f44866c = provider3;
        this.f44867d = provider4;
        this.f44868e = provider5;
        this.f44869f = provider6;
    }

    public static qm b(jr jrVar, nm nmVar, lm lmVar, cq cqVar, fm fmVar, rq rqVar) {
        return new qm(jrVar, nmVar, lmVar, cqVar, fmVar, rqVar);
    }

    public static rm c(Provider<jr> provider, Provider<nm> provider2, Provider<lm> provider3, Provider<cq> provider4, Provider<fm> provider5, Provider<rq> provider6) {
        return new rm(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public qm get() {
        return b(this.f44864a.get(), this.f44865b.get(), this.f44866c.get(), this.f44867d.get(), this.f44868e.get(), this.f44869f.get());
    }
}
