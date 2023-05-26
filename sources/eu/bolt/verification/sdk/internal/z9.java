package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class z9 implements Factory<y9> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final z9 f45843a = new z9();
    }

    public static z9 a() {
        return a.f45843a;
    }

    public static y9 c() {
        return new y9();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public y9 get() {
        return c();
    }
}
