package eu.bolt.verification.sdk.internal;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class jq implements Factory<iq> {

    /* loaded from: classes5.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final jq f43777a = new jq();
    }

    public static jq a() {
        return a.f43777a;
    }

    public static iq c() {
        return new iq();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public iq get() {
        return c();
    }
}
