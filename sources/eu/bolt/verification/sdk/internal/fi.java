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
public final class fi implements Factory<ei> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<di> f42993a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<yh> f42994b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RxActivityEvents> f42995c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<mg> f42996d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<gi> f42997e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<bg> f42998f;

    public fi(Provider<di> provider, Provider<yh> provider2, Provider<RxActivityEvents> provider3, Provider<mg> provider4, Provider<gi> provider5, Provider<bg> provider6) {
        this.f42993a = provider;
        this.f42994b = provider2;
        this.f42995c = provider3;
        this.f42996d = provider4;
        this.f42997e = provider5;
        this.f42998f = provider6;
    }

    public static ei b(di diVar, yh yhVar, RxActivityEvents rxActivityEvents, mg mgVar, gi giVar, bg bgVar) {
        return new ei(diVar, yhVar, rxActivityEvents, mgVar, giVar, bgVar);
    }

    public static fi c(Provider<di> provider, Provider<yh> provider2, Provider<RxActivityEvents> provider3, Provider<mg> provider4, Provider<gi> provider5, Provider<bg> provider6) {
        return new fi(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public ei get() {
        return b(this.f42993a.get(), this.f42994b.get(), this.f42995c.get(), this.f42996d.get(), this.f42997e.get(), this.f42998f.get());
    }
}
