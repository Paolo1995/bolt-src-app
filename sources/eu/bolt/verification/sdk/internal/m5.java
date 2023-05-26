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
public final class m5 implements Factory<l5> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RxActivityEvents> f44153a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<g7> f44154b;

    public m5(Provider<RxActivityEvents> provider, Provider<g7> provider2) {
        this.f44153a = provider;
        this.f44154b = provider2;
    }

    public static l5 b(RxActivityEvents rxActivityEvents, g7 g7Var) {
        return new l5(rxActivityEvents, g7Var);
    }

    public static m5 c(Provider<RxActivityEvents> provider, Provider<g7> provider2) {
        return new m5(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public l5 get() {
        return b(this.f44153a.get(), this.f44154b.get());
    }
}
