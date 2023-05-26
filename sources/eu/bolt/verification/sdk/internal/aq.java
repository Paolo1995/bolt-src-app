package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class aq implements Factory<zp> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final aq f42222a = new aq();
    }

    public static aq a() {
        return a.f42222a;
    }

    public static zp c() {
        return new zp();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public zp get() {
        return c();
    }
}
