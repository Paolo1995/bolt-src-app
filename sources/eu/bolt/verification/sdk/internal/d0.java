package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class d0 implements Factory<c0> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final d0 f42572a = new d0();
    }

    public static d0 a() {
        return a.f42572a;
    }

    public static c0 c() {
        return new c0();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public c0 get() {
        return c();
    }
}
