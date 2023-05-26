package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class me implements Factory<le> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final me f44175a = new me();
    }

    public static me a() {
        return a.f44175a;
    }

    public static le c() {
        return new le();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public le get() {
        return c();
    }
}
