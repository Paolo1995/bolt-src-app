package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class ee implements Factory<de> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final ee f42759a = new ee();
    }

    public static ee a() {
        return a.f42759a;
    }

    public static de c() {
        return new de();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public de get() {
        return c();
    }
}
