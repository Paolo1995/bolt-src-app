package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class e2 implements Factory<d2> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final e2 f42686a = new e2();
    }

    public static e2 a() {
        return a.f42686a;
    }

    public static d2 c() {
        return new d2();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public d2 get() {
        return c();
    }
}
