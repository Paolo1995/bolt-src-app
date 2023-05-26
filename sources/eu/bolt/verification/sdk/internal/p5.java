package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.verification.sdk.internal.o5;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.client.ribsshared.error.dialog.DialogErrorBuilder.DialogErrorScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class p5 implements Factory<t5> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<o5.b> f44501a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<u5> f44502b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<r5> f44503c;

    public p5(Provider<o5.b> provider, Provider<u5> provider2, Provider<r5> provider3) {
        this.f44501a = provider;
        this.f44502b = provider2;
        this.f44503c = provider3;
    }

    public static p5 a(Provider<o5.b> provider, Provider<u5> provider2, Provider<r5> provider3) {
        return new p5(provider, provider2, provider3);
    }

    public static t5 c(o5.b bVar, u5 u5Var, r5 r5Var) {
        return (t5) Preconditions.checkNotNullFromProvides(o5.c.a(bVar, u5Var, r5Var));
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public t5 get() {
        return c(this.f44501a.get(), this.f44502b.get(), this.f44503c.get());
    }
}
