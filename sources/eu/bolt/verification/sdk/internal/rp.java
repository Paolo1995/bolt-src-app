package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class rp implements Factory<qp> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final rp f44915a = new rp();
    }

    public static rp a() {
        return a.f44915a;
    }

    public static qp c() {
        return new qp();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public qp get() {
        return c();
    }
}
