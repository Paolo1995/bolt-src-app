package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.e8;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.ribsshared.error.fullscreen.FullScreenErrorBuilder.FullScreenErrorScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class f8 implements Factory<k8> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<e8.b> f42970a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<m8> f42971b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<i8> f42972c;

    public f8(Provider<e8.b> provider, Provider<m8> provider2, Provider<i8> provider3) {
        this.f42970a = provider;
        this.f42971b = provider2;
        this.f42972c = provider3;
    }

    public static f8 a(Provider<e8.b> provider, Provider<m8> provider2, Provider<i8> provider3) {
        return new f8(provider, provider2, provider3);
    }

    public static k8 c(e8.b bVar, m8 m8Var, i8 i8Var) {
        return (k8) Preconditions.checkNotNullFromProvides(e8.c.a(bVar, m8Var, i8Var));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public k8 get() {
        return c(this.f42970a.get(), this.f42971b.get(), this.f42972c.get());
    }
}
