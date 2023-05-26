package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.ribsshared.error.fullscreen.FullScreenErrorBuilder.FullScreenErrorScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class o8 implements Factory<n8> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<m8> f44441a;

    public o8(Provider<m8> provider) {
        this.f44441a = provider;
    }

    public static n8 b(m8 m8Var) {
        return new n8(m8Var);
    }

    public static o8 c(Provider<m8> provider) {
        return new o8(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public n8 get() {
        return b(this.f44441a.get());
    }
}
