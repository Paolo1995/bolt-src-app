package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class oo implements Factory<no> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final oo f44479a = new oo();
    }

    public static oo a() {
        return a.f44479a;
    }

    public static no c() {
        return new no();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public no get() {
        return c();
    }
}
