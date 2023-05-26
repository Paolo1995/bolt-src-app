package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.rib.RxActivityEvents;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class u6 implements Factory<t6> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<p6> f45332a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<s6> f45333b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RxActivityEvents> f45334c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<bg> f45335d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ml> f45336e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<y6> f45337f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<bg> f45338g;

    public u6(Provider<p6> provider, Provider<s6> provider2, Provider<RxActivityEvents> provider3, Provider<bg> provider4, Provider<ml> provider5, Provider<y6> provider6, Provider<bg> provider7) {
        this.f45332a = provider;
        this.f45333b = provider2;
        this.f45334c = provider3;
        this.f45335d = provider4;
        this.f45336e = provider5;
        this.f45337f = provider6;
        this.f45338g = provider7;
    }

    public static t6 b(p6 p6Var, s6 s6Var, RxActivityEvents rxActivityEvents, bg bgVar, ml mlVar, y6 y6Var, bg bgVar2) {
        return new t6(p6Var, s6Var, rxActivityEvents, bgVar, mlVar, y6Var, bgVar2);
    }

    public static u6 c(Provider<p6> provider, Provider<s6> provider2, Provider<RxActivityEvents> provider3, Provider<bg> provider4, Provider<ml> provider5, Provider<y6> provider6, Provider<bg> provider7) {
        return new u6(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public t6 get() {
        return b(this.f45332a.get(), this.f45333b.get(), this.f45334c.get(), this.f45335d.get(), this.f45336e.get(), this.f45337f.get(), this.f45338g.get());
    }
}
