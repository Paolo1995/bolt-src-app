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
public final class v2 implements Factory<u2> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<y2> f45424a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<o2> f45425b;

    public v2(Provider<y2> provider, Provider<o2> provider2) {
        this.f45424a = provider;
        this.f45425b = provider2;
    }

    public static u2 b(y2 y2Var, o2 o2Var) {
        return new u2(y2Var, o2Var);
    }

    public static v2 c(Provider<y2> provider, Provider<o2> provider2) {
        return new v2(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public u2 get() {
        return b(this.f45424a.get(), this.f45425b.get());
    }
}
