package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class h7 implements Factory<g7> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final h7 f43344a = new h7();
    }

    public static h7 a() {
        return a.f43344a;
    }

    public static g7 c() {
        return new g7();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public g7 get() {
        return c();
    }
}
