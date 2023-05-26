package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class hq implements Factory<gq> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final hq f43423a = new hq();
    }

    public static hq a() {
        return a.f43423a;
    }

    public static gq c() {
        return new gq();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public gq get() {
        return c();
    }
}
