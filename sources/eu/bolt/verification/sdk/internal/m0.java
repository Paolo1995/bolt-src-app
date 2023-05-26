package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class m0 implements Factory<l0> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final m0 f44111a = new m0();
    }

    public static m0 a() {
        return a.f44111a;
    }

    public static l0 c() {
        return new l0();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public l0 get() {
        return c();
    }
}
