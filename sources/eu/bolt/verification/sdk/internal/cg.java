package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.android.rib.CoActivityEvents;
import eu.bolt.android.rib.RxActivityEvents;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class cg implements Factory<bg> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<dl> f42510a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<s> f42511b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CoActivityEvents> f42512c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<RxActivityEvents> f42513d;

    public cg(Provider<dl> provider, Provider<s> provider2, Provider<CoActivityEvents> provider3, Provider<RxActivityEvents> provider4) {
        this.f42510a = provider;
        this.f42511b = provider2;
        this.f42512c = provider3;
        this.f42513d = provider4;
    }

    public static bg b(dl dlVar, s sVar, CoActivityEvents coActivityEvents, RxActivityEvents rxActivityEvents) {
        return new bg(dlVar, sVar, coActivityEvents, rxActivityEvents);
    }

    public static cg c(Provider<dl> provider, Provider<s> provider2, Provider<CoActivityEvents> provider3, Provider<RxActivityEvents> provider4) {
        return new cg(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public bg get() {
        return b(this.f42510a.get(), this.f42511b.get(), this.f42512c.get(), this.f42513d.get());
    }
}
