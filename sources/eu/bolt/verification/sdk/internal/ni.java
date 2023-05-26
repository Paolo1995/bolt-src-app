package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ni implements Factory<mi> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final ni f44345a = new ni();
    }

    public static ni a() {
        return a.f44345a;
    }

    public static mi c() {
        return new mi();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public mi get() {
        return c();
    }
}
