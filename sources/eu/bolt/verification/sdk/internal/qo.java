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
public final class qo implements Factory<po> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<iq> f44685a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<um> f44686b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<so> f44687c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<gq> f44688d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<qm> f44689e;

    public qo(Provider<iq> provider, Provider<um> provider2, Provider<so> provider3, Provider<gq> provider4, Provider<qm> provider5) {
        this.f44685a = provider;
        this.f44686b = provider2;
        this.f44687c = provider3;
        this.f44688d = provider4;
        this.f44689e = provider5;
    }

    public static po b(iq iqVar, um umVar, so soVar, gq gqVar, qm qmVar) {
        return new po(iqVar, umVar, soVar, gqVar, qmVar);
    }

    public static qo c(Provider<iq> provider, Provider<um> provider2, Provider<so> provider3, Provider<gq> provider4, Provider<qm> provider5) {
        return new qo(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public po get() {
        return b(this.f44685a.get(), this.f44686b.get(), this.f44687c.get(), this.f44688d.get(), this.f44689e.get());
    }
}
