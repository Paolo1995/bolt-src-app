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
public final class x2 implements Factory<w2> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<y2> f45602a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<q2> f45603b;

    public x2(Provider<y2> provider, Provider<q2> provider2) {
        this.f45602a = provider;
        this.f45603b = provider2;
    }

    public static w2 b(y2 y2Var, q2 q2Var) {
        return new w2(y2Var, q2Var);
    }

    public static x2 c(Provider<y2> provider, Provider<q2> provider2) {
        return new x2(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public w2 get() {
        return b(this.f45602a.get(), this.f45603b.get());
    }
}
