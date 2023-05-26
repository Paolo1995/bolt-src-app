package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("eu.bolt.verification.core.rib.formbuilder.FormBuilderBuilder.FormBuilderScope")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class p7 implements Factory<o7> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<v7> f44510a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<db> f44511b;

    public p7(Provider<v7> provider, Provider<db> provider2) {
        this.f44510a = provider;
        this.f44511b = provider2;
    }

    public static o7 b(v7 v7Var, db dbVar) {
        return new o7(v7Var, dbVar);
    }

    public static p7 c(Provider<v7> provider, Provider<db> provider2) {
        return new p7(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: a */
    public o7 get() {
        return b(this.f44510a.get(), this.f44511b.get());
    }
}
